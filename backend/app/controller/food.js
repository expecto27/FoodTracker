var db = require('../config/db.config.js');
var Food = db.food; // название модели смотреть в init-models.js
const { Sequelize} = require("../config/db.config");
exports.getFoods = async (req, res) => {
    try {
      const { title } = req.query;
      const foods = await Food.findAll({
        where: {
          title: {
            [Sequelize.Op.like]: `%${title}%`, // Правильное использование оператора Op.like
          },
        },
      });
      res.json(foods);
    } catch (error) {
      console.error('Ошибка при поиске еды:', error);
      res.status(500).json({ error: 'Ошибка при выполнении запроса' });
    }
  };