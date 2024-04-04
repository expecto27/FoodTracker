var DataTypes = require("sequelize").DataTypes;
var _food = require("./food");

function initModels(sequelize) {
  var food = _food(sequelize, DataTypes);


  return {
    food,
  };
}
module.exports = initModels;
module.exports.initModels = initModels;
module.exports.default = initModels;
//
