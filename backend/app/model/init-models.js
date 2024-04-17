var DataTypes = require("sequelize").DataTypes;
var _food = require("./food");
var _users = require("./users");

function initModels(sequelize) {
  var food = _food(sequelize, DataTypes);
  var users = _users(sequelize, DataTypes);


  return {
    food,
    users,
  };
}
module.exports = initModels;
module.exports.initModels = initModels;
module.exports.default = initModels;
