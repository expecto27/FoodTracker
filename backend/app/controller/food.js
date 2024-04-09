var db = require('../config/db.config.js');
var Food = db.food; // название модели смотреть в init-models.js
const { sequelize} = require("../config/db.config");
exports.getFoods = async (req, res) => {
    try {
        const { title } = req.query;
        const query = `
                SELECT * FROM food WHERE MATCH(product_name, categories, brands) AGAINST(:title);
        `;
        const foods = await sequelize.query(query, {
            replacements: { title: `${title}` },
            type: sequelize.QueryTypes.SELECT
        });
        res.json(foods);
    } catch (error) {
        console.error('Ошибка при поиске еды:', error);
        res.status(500).json({ error: 'Ошибка при выполнении запроса' });
    }
};