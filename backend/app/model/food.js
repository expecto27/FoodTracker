const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('food', {
    id: {
      autoIncrement: true,
      type: DataTypes.BIGINT,
      allowNull: false,
      primaryKey: true
    },
    product_name: {
      type: DataTypes.TEXT,
      allowNull: true
    },
    quantity: {
      type: DataTypes.TEXT,
      allowNull: true
    },
    packaging: {
      type: DataTypes.TEXT,
      allowNull: true
    },
    brands: {
      type: DataTypes.TEXT,
      allowNull: true
    },
    categories: {
      type: DataTypes.TEXT,
      allowNull: true
    },
    stores: {
      type: DataTypes.TEXT,
      allowNull: true
    },
    countries: {
      type: DataTypes.TEXT,
      allowNull: true
    },
    serving_size: {
      type: DataTypes.TEXT,
      allowNull: true
    },
    serving_quantity: {
      type: DataTypes.DOUBLE,
      allowNull: true
    },
    nutriscore_score: {
      type: DataTypes.DOUBLE,
      allowNull: true
    },
    nutriscore_grade: {
      type: DataTypes.TEXT,
      allowNull: true
    },
    image_url: {
      type: DataTypes.TEXT,
      allowNull: true
    },
    image_small_url: {
      type: DataTypes.TEXT,
      allowNull: true
    },
    'energy-kj_100g': {
      type: DataTypes.DOUBLE,
      allowNull: true
    },
    'energy-kcal_100g': {
      type: DataTypes.DOUBLE,
      allowNull: true
    },
    energy_100g: {
      type: DataTypes.DOUBLE,
      allowNull: true
    },
    'energy-from-fat_100g': {
      type: DataTypes.DOUBLE,
      allowNull: true
    },
    fat_100g: {
      type: DataTypes.DOUBLE,
      allowNull: true
    },
    'saturated-fat_100g': {
      type: DataTypes.DOUBLE,
      allowNull: true
    },
    carbohydrates_100g: {
      type: DataTypes.DOUBLE,
      allowNull: true
    },
    proteins_100g: {
      type: DataTypes.DOUBLE,
      allowNull: true
    }
  }, {
    sequelize,
    tableName: 'food',
    timestamps: false,
    indexes: [
      {
        name: "PRIMARY",
        unique: true,
        using: "BTREE",
        fields: [
          { name: "id" },
        ]
      },
    ]
  });
};
