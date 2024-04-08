const { json } = require("sequelize");
const { Sequelize} = require("../config/db.config");
module.exports = (app) => {

    const food = require('../controller/food.js');
    app.get('/api/foods', food.getFoods);
    app.get('/', async (req, res) => {
        res.json({code: '500'})
    } );
};