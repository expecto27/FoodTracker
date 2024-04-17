var express = require('express');
var app = express();
var bodyParser = require('body-parser');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

var db = require('./app/config/db.config.js');
db.sequelize.sync({force: false});

app.listen(3000);
var food = require('./app/route/food');
var auth = require('./app/route/auth.js');
food(app);
auth(app);