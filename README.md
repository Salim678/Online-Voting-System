🗳️ Online Voting System – Java Web Application

📌 Project Overview

The Online Voting System is a secure Java web-based application that allows registered voters to log in and cast their vote only once, ensuring fairness and data integrity. The system also provides an Admin module to manage candidates and view real-time election results.

The application is designed and implemented according to the Java Web-Based Project Review-2 Rubric, focusing on clean architecture, security, robustness, and innovation.

🎯 Objectives

▫️Provide a secure online voting platform

▫️Enforce one-voter-one-vote policy

▫️Prevent unauthorized access using session management

▫️Maintain data integrity using atomic transactions

▫️Demonstrate Java Web technologies using best practices

⭐ Key Features

👤 Voter Module

▫️Online voter registration

▫️Secure login with server-side validation

▫️One-voter-one-vote enforcement

▫️View list of candidates

▫️Cast vote securely

▫️View vote confirmation

▫️Session-based access control

🛠️ Admin Module

▫️Admin login

▫️Add, update, delete, and view candidates

▫️View total votes for each candidate

▫️View real-time election results

▫️Restricted access using role-based authorization

🔐 Security & Integrity Measures

▫️Password hashing for secure authentication

▫️Atomic transaction handling for vote casting

▫️Servlet Filter for role-based authorization

▫️Session management for secure navigation

▫️Database constraints to prevent invalid data

▫️PreparedStatements to avoid SQL injection

💻 Technologies Used

▫️Java (Core Java & OOP concepts)

▫️JSP & Servlets

▫️JDBC

▫️MySQL Database

▫️Apache Tomcat Server

▫️HTML/CSS

🧱 System Architecture

▫️The project follows the MVC (Model–View–Controller) architecture:

▫️Model → Java Beans & DAO classes

▫️DAO Layer → Handles all database operations

▫️Controller → Servlets for request handling

▫️View → JSP pages for UI

▫️This separation improves maintainability, scalability, and code quality.

📁 Project Structure
src/
 ├── model/        (Entity classes)
 ├── dao/          (Database access objects)
 ├── service/      (Business logic & validation)
 ├── web/          (Servlets & Filters)
 └── util/         (DB connection utility)

WebContent/
 ├── admin.jsp
 ├── vote.jsp
 ├── results.jsp
 ├── login.jsp
 ├── register.jsp
 └── index.jsp

database/
 ├── voting.sql
 └── voting_db.sql

README.md

🗄️ Database Design

The database consists of the following tables:

▫️Voters

   ▫️Stores voter credentials and voting status

   ▫️Enforces UNIQUE(email) and CHECK(has_voted)

▫️Candidates

   ▫️Stores candidate details

▫️Votes

   ▫️Stores vote records

   ▫️Uses foreign keys and unique constraints to prevent duplicate voting

The database is normalized and uses constraints to ensure data integrity.

🔁 Atomic Transaction (Key Innovation)

▫️The vote casting process is implemented using a single atomic JDBC transaction:

▫️Insert vote record

▫️Update voter status to Voted

▫️Commit if both succeed

▫️Rollback if any step fails

This guarantees consistency and prevents double voting.

🧪 Testing Performed

▫️Login with valid and invalid credentials

▫️Attempt double voting

▫️Direct URL access without login

▫️Admin access restriction testing

▫️Session invalidation after logout

Manual testing confirms correct functionality and robustness.

🚀 Innovation / Extra Effort

▫️Atomic transaction management for voting

▫️Dual-level double-voting prevention (Application + Database)

▫️Servlet Filter for role-based authorization

▫️Clean DAO-based architecture

▫️Secure session lifecycle handling

🤝 Teamwork & Collaboration

▫️Project developed using GitHub for version control

▫️Modular development approach

▫️Clear separation of responsibilities across layers

▫️README documentation maintained for clarity

📊 Results

▫️Votes are counted accurately

▫️Results are displayed in real time

▫️System prevents duplicate or invalid voting attempts

✅ Conclusion

The Online Voting System successfully demonstrates a secure, robust, and well-structured Java web application. By combining MVC architecture, DAO pattern, atomic transactions, and database constraints, the system ensures fairness, security, and reliability in the voting process.
