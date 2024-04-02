//const { Sequence } = require("mysql2/typings/mysql/lib/protocol/sequences/Sequence");
const { Sequelize} = require("../config/db.config");
module.exports = (app) => {

    const food = require('../controller/food.js');
    app.get('/api/foods', food.getFoods);

};