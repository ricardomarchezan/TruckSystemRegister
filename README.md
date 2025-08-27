Truck Fleet Manager (Java Swing)
A desktop application built with Java Swing to manage and report on three common truck categories in Brazilian logistics: VUC, TOCO, and TRUCK. It showcases robust CRUD operations, responsive reporting via JTable, clean patterns, and a frictionless UX for desktop.

This project is production-ready for demos and portfolio use. It reflects strong proficiency in:

Java SE and Swing with NetBeans GUI Builder (GroupLayout)
Design patterns (Singleton per Form)
Data validation and exception handling
Thoughtful desktop UX (window lifecycle, sizing, focus, single-instance forms)
Clean separation of concerns: model, in-memory repository, and UI
Table of Contents
Overview
Features
Architecture and Design Decisions
Project Structure
Requirements
Getting Started
Usage Guide
Data Model
Troubleshooting
Roadmap
License
Author
Overview
The application provides a main window (FormPrincipal) as the navigation hub:

Registrations: VUC, TOCO, TRUCK
Reports: VUC, TOCO, TRUCK (each with a dedicated JTable)
All data is stored in memory through simple repository classes, making the app lightweight and easy to run. Reports reflect the latest state via an explicit table refresh method.

Features
Full CRUD for:
VUC (Veículo Urbano de Carga)
TOCO
TRUCK
Reporting by category:
On-demand refresh via atualizarTabela()
Purpose-built column sets per vehicle type
Validation and error handling:
Year validation (InvalidAnoException)
Capacity/autonomy validation where applicable (InvalidCapacidadeException)
Numeric parsing with user feedback
Polished desktop UX:
Forms use DISPOSE_ON_CLOSE (closing a child window doesn’t exit the app)
The main window uses EXIT_ON_CLOSE
After a successful save, the registration form closes automatically
Forms are centered and correctly sized with pack()
Architecture and Design Decisions
Singleton per Form
Prevents multiple instances of the same registration/report window
Examples: FormVuc.getInstance(), FormRelToco.getInstance(), etc.
Clear separation of responsibilities:
Model: Vuc, Toco, Truck
In-memory repositories: BDVuc, BDToco, BDTruck
UI: FormPrincipal, FormVuc, FormToco, FormTruck, FormRelVuc, FormRelToco, FormRelTruck
Reporting with explicit refresh:
Open reports using FormRelXxx.getInstance().atualizarTabela().setVisible(true)
Correct window lifecycle:
Only FormPrincipal uses EXIT_ON_CLOSE
All other forms use DISPOSE_ON_CLOSE
Built using NetBeans GUI Builder:
GroupLayout managed within initComponents()
Correct sizing via pack()
Project Structure
Example layout (your IDE may display differently):


/src
  FormPrincipal.java
  FormVuc.java
  FormToco.java
  FormTruck.java
  FormRelVuc.java
  FormRelToco.java
  FormRelTruck.java
  Vuc.java
  Toco.java
  Truck.java
  BDVuc.java
  BDToco.java
  BDTruck.java
  InvalidAnoException.java
  InvalidCapacidadeException.java
Notes:

Repositories (BD*) keep data in memory with methods: inserir, consultar, atualizar, excluir, listarTodos.
Report forms implement atualizarTabela() to populate the JTable from listarTodos().
Requirements
JDK 8+ (Java 11+ recommended)
Any IDE; NetBeans 12+ recommended for GUI Builder
Useful links:

AdoptOpenJDK/Temurin: https://adoptium.net
Apache NetBeans: https://netbeans.apache.org
Getting Started
Option A — Run from IDE (recommended):

Open the project in NetBeans.
Build the project (Clean and Build).
Run the main class: FormPrincipal.
Option B — Run from terminal (simple case without packages):

Navigate to the src directory and compile:

javac *.java
Run the main class:

java FormPrincipal
If you use packages (package declarations), adjust the compile/run commands accordingly.

Usage Guide
Registrations (Menu “Cadastros”):
Open VUC/TOCO/TRUCK forms to create, read, update, or delete records.
After a successful save, the form closes automatically (dispose()) and you return to the main window.
Reports (Menu “Relatorios”):
Open the desired report (VUC/TOCO/TRUCK).
The table is refreshed on open using atualizarTabela().
Developer tips:

Open report forms like this from the main menu:

FormRelVuc.getInstance().atualizarTabela().setVisible(true);
To ensure a single instance per window, always access forms via getInstance().
Data Model
Vuc
placa, marca, ano, circulaCentro (boolean), refrigerado (boolean)
Toco
placa, marca, ano, tipoCarroceria, autonomiaKm (int)
Truck
placa, marca, ano, qtdEixosTraseiros (int), tipoSuspensao
Primary key for lookups: placa. Data is reset each time the app starts.

Troubleshooting
A report opens the wrong window:
Ensure the menu action calls the correct class:

FormRelVuc.getInstance().atualizarTabela().setVisible(true);
“Cannot find atualizarTabela()” on report calls:
Fix the Singleton in the report forms so getInstance() returns the correct FormRelXxx type (not FormVuc).
Closing a child form closes the entire app:
Use DISPOSE_ON_CLOSE for registration/report forms; keep EXIT_ON_CLOSE only on FormPrincipal.
Tiny or empty windows:
Make sure the constructor calls initComponents() and pack(). The GUI Builder places pack() at the end of initComponents()—do not remove it.
Close the registration form after saving:
On successful save, call this.dispose() in the Save button handler.
Roadmap
Persist data using an embedded database (SQLite/H2 via JDBC)
Export and print reports (CSV/Excel/PDF)
Sorting and filtering within JTables
Unit tests for models and repositories (JUnit)
Internationalization (pt-BR/en-US) and custom Look & Feel
Input masks and richer validations (e.g., license plate masks)
Explicit MVC layering (Controller/Service classes)
License
Recommended: MIT License. Include a LICENSE file in the repository.

Author
Ricardo — Developer and UI
Open to feedback, contributions, and freelance opportunities
Why this project stands out:

Demonstrates practical Swing proficiency with clean UI patterns
Applies correct window lifecycle and single-instance form handling
Clear, extensible code that’s easy to evolve (persistence, exports, filters)
Strong UX focus for desktop applications
