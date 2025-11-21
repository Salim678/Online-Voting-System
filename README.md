🗳️ Online Voting System – Java Web Application

The Online Voting System is a Java web application that enables registered voters to securely log in and cast their votes. Each voter is allowed to vote only one time, ensuring fairness.
An admin user can add candidates and view real-time voting results.

This project is built according to the Java Web-Based Project Review Rubric, covering:

▫️Core Java Concepts

▫️OOP Principles

▫️JDBC & MySQL

▫️Servlets & JSP

▫️Database Schema

▫️System Design Diagrams

⭐ Features

👤 Voter Module

▫️Online voter registration

▫️Secure login system

▫️One-voter-one-vote enforcement

▫️View candidate list

▫️Cast vote

▫️View voting confirmation

🛠️ Admin Module

▫️ Admin login

▫️Add, update, delete, view candidates

▫️View total votes for each candidate

▫️View election results

💻 Technologies Used

▫️Java

▫️JSP & Servlets

▫️JDBC

▫️MySQL

▫️Tomcat Server

▫️HTML/CSS

📁 Project Structure

 ▫️src/ – Java files (models, DAOs, servlets, utilities)

 ▫️WebContent/ – JSP pages, HTML files, and UI resources

 ▫️database/ – Database design file

 ▫️README.md – Documentation

📌 Database Design

The database includes tables for:

▫️Users

▫️Candidates

▫️Votes

Each table is structured to support secure login, one-time voting, and candidate management.

📌 Application Pages

 ▫️Login Page

 ▫️Registration Page

 ▫️Voter Dashboard

 ▫️Candidate List

 ▫️Vote Page

 ▫️Admin Dashboard

 📊 General

  Automatically prevents double-voting

  Simple result page (vote count per candidate)

  MySQL integration using JDBC

  Follows MVC pattern (Model → DAO → Servlet → JSP)
