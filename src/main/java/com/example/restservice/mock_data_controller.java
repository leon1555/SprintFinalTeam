package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mock_data_controller {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}


//const express = require('express');
//        const app = express();
//        const pg = require('pg');
//        const session = require('express-session');
//        const nunjucks = require('nunjucks');
//        const port = 3001;
//        const path = require('path');
//        const bcrypt = require('bcrypt');
//        const mongodb = require('mongodb');
//
////Mongo Db connection
//        const uri = "mongodb://localhost";
//        const client = new mongodb.MongoClient(uri);
//
//        nunjucks.configure('views', {
//        autoescape: true,
//        express: app
//        });
////Postgress Connection
//        const pool = new pg.Pool({
//        user: 'me',
//        host: 'localhost',
//        database: 'sprint3Sem3',
//        password: 'password',
//        port: 5432
//        });
//
//        app.use(session({secret:"googlized"}));
//        app.use(express.json());
//        app.use(express.urlencoded({
//        extended: true
//        }));
////Homepage
//        app.get("/", function(res,res){
//        res.sendFile(path.join(__dirname, '/views/root.html'));
//
//        });
//
//        app.get("/login", function(res,res){
//        res.sendFile(path.join(__dirname, '/views/login.html'));
//        });
//
//        app.post("/login", async function(req, res){
//        const email = req.body.email;
//        const password = req.body.password;
//
//        let outcome = await pool.query("SELECT * FROM user_table WHERE email=$1", [email]);
//
//        if(outcome.rows < 1 ){
//        res.send("Incorrect email, no account with that username.");
//        }else{
//        if(await bcrypt.compare(password, outcome.rows[0].password)){
//        //adding loggedin and email to session for authentication and database usage.
//        req.session.loggedin = true;
//        req.session.user_id = email;
//        res.redirect("/search");
//        }else{
//        res.send("Invalid password, please enter the correct password.")
//        };
//
//        };
//        });
//
//        app.get("/signup", function(res,res){
//        res.sendFile(path.join(__dirname, '/views/signup.html'));
//
//        });
//
//        app.post("/signup", async function(req, res){
//        let email = req.body.email;
//        let password = req.body.password;
//        let confirm_password = req.body.confirm_password
//
//        let outcome = await pool.query('SELECT * FROM user_table WHERE email=$1',[email]);
//        if(outcome.rows.length > 0){
//        res.send("Try again, That email is taken.");
//        }else{
//        if(password === confirm_password){
//        let hashed_password = await bcrypt.hash(password, 10);
//        let inserted_value = pool.query('INSERT INTO user_table(email, password)VALUES($1, $2)', [email, hashed_password]);
//        res.redirect('/login');
//        }
//        };
//
//        });
//
//        app.get("/search",async function main(req,res){
//        //loggedin tfor authetication
//        if(req.session.loggedin === true){
//        let searches = await req.query.search_input
//        let datetime = new Date();
//        let user_id = await req.session.user_id;
//        if (searches === " "&& searches === undefined){
//        return;
//        }else{
//        //INSERT search queries into postgres
//        let query_search = '%' + searches + '%';
//        let input = await pool.query('INSERT INTO searches(searches,user_id,datetime) VALUES ($1, $2, $3)',[searches, user_id, datetime]);
//        //POSTGRES
//        if(req.query.db === 'postgres'){
//        if(searches.length > 1){
//        let results = await pool.query('SELECT * FROM mock_data WHERE buzzwords ILIKE $1 OR city ILIKE $1 OR year ILike $1',[query_search]);
//        let arr = results.rows;
//        res.render("result.njk",
//        {
//        heading: "Postgres",
//        postgres_results: arr,
//        displayList: true
//        })
//        return;
//        }else{
//        console.log("incomplete")
//        }
//        //MONGODB
//        }else if(req.query.db === 'mongoDB'){
//        await client.connect();
//        let search_query = searches.toString();
//        let mongo_results = await client.db('sprint3Sem3').collection('Dataset').find({$or:[{Buzzwords: new RegExp(search_query)},{App_Name: new RegExp(search_query)},{Company_Names: new RegExp(search_query)},{user_agent: new RegExp(search_query)}]}).toArray();
//        res.render("result.njk",
//        {
//        heading2: "MongoDB",
//        mongodb_results: mongo_results,
//        displayList: true
//        })
//
//        await client.close();
//        return;
//        //BOTH
//        }else if(req.query.db === 'both'){
//        if(searches.length > 1){
//        let results = await pool.query('SELECT * FROM mock_data WHERE buzzwords ILIKE $1 OR city ILIKE $1 OR year ILike $1',[query_search]);
//        let arr = results.rows;
//        await client.connect();
//        let search_query = searches.toString();
//        let mongo_results = await client.db('sprint3Sem3').collection('Dataset').find({$or:[{Buzzwords: new RegExp(search_query)},{App_Name: new RegExp(search_query)},{Company_Names: new RegExp(search_query)},{user_agent: new RegExp(search_query)}]}).toArray();
//        res.render("result.njk",
//        {
//        heading: "Postgres",
//        postgres_results: arr,
//        heading2: "MongoDB",
//        mongodb_results: mongo_results,
//        displayList: true
//        })
//        await client.close();
//        return;
//        }else{
//        console.log("incomplete")
//        }
//        }
//        }
//        res.sendFile(path.join(__dirname, '/views/index.html'))
//        }else{
//        res.send('you must be logged in to see this page.')
//        }
//        });
//
//        app.get('/logout', function(req, res){
//        req.session.destroy();
//        res.redirect('/');
//        });
//
//        app.listen(port, function (){
//        console.log(`listening at http://localhost:${port}`)
//        });

