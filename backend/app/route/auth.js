const { json } = require("sequelize");
const { Sequelize} = require("../config/db.config");
const { User } = require("../model/users");
module.exports = (app) => {

    app.post('/api/register', async (req, res) =>{
        const {name, mail, pass} = req.body;
        // const salt = await bcrypt.genSalt(1022);
        // const hashedPassword = await bcrypt.hash(password, salt);

        const newUser = {
            username : name,
            email: mail,
            password: pass
        }

        User.create()
        .then(() => {
            res.status(200).json({ message: 'Пользователь успешно создан' });
        })
        .catch(error => {
            console.error('Ошибка:', error);
            res.status(500).json({ message: 'Произошла ошибка при создании пользователя' });
        });

        res.status(200).json({ message: 'Пользователь успешно зарегистрирован' });

    } );
   
    
    app.post('/api/login', async (req, res) => {
        const { name, pass } = req.body;
        try {
            const foundUser = await user.findOne({ where: { username: name } });
    
            if (!foundUser) {
                return res.status(401).json({ message: 'Неверное имя пользователя или пароль' });
            }

            const isPasswordValid = foundUser.password == pass
            //const isPasswordValid = await bcrypt.compare(password, foundUser.password);
    
            if (isPasswordValid) {
                res.status(200).json({ message: 'Успешная аутентификация' });
            } else {
                res.status(401).json({ message: 'Неверное имя пользователя или пароль' });
            }
        } catch (error) {
            console.error(error);
            res.status(500).json({ message: 'Произошла ошибка при аутентификации пользователя' });
        }
    });


};