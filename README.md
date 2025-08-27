# Truck Fleet Manager (Java Swing)

![Java](https://img.shields.io/badge/Java-8%2B-blue) ![Swing](https://img.shields.io/badge/UI-Swing-orange) ![Build](https://img.shields.io/badge/Build-NetBeans%2012%2B-blueviolet) ![License](https://img.shields.io/badge/License-MIT-green)

A robust desktop application built with Java Swing for managing a comprehensive truck fleet registry. The system is segmented by vehicle category (VUC, Toco, and Truck) and implements a professional workflow, including CRUD operations, dynamic reporting, and a clean, extensible architecture.

This project serves as an excellent portfolio piece, demonstrating proficiency in:
- **Java SE & Swing** with the NetBeans GUI Builder.
- **Design Patterns** (Singleton, Simplified MVC).
- **Data Validation** and custom exception handling.
- **Desktop-centric UX**, including proper window lifecycle management and real-time component updates.

---

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Architecture and Design Decisions](#architecture-and-design-decisions)
- [Screenshots](#screenshots)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Future Roadmap](#future-roadmap)
- [License](#license)
- [Author](#author)

---

## Overview

The application's navigation is centralized in a main window (`FormPrincipal`), which acts as a hub for accessing the **Registration** and **Reporting** modules. Each truck category has its own dedicated CRUD form and report screen, ensuring an organized and intuitive interface. Data is managed in-memory for agility and ease of execution.

## Features

- **Full CRUD Operations**:
  - Create, Read, Update, and Delete for VUC, Toco, and Truck vehicles.
- **Dynamic Reporting**:
  - `JTable` reports that are updated in real-time whenever the report screen is accessed.
- **Input Validation**:
  - Custom exception handling for invalid data entries (e.g., year, capacity).
  - User-friendly feedback via `JOptionPane` for errors and confirmations.
- **Optimized User Experience (UX)**:
  - **Window Management**: Only the main window exits the application (`EXIT_ON_CLOSE`), while child forms are disposed (`DISPOSE_ON_CLOSE`), preserving the workflow.
  - **Fluid Navigation**: After a successful save, the registration form closes automatically.
  - **Responsive Layout**: Windows automatically resize to fit their content using the `pack()` method.

## Architecture and Design Decisions

- **Singleton Pattern**: Each `JFrame` is implemented as a Singleton to ensure only one instance of each window is active at any time, preventing duplicates and conserving resources.
- **Separation of Concerns**:
  - **Model**: Domain classes (`Vuc`, `Toco`, `Truck`) representing the data.
  - **View**: Swing forms (`FormVuc`, `FormRelToco`, etc.) responsible for the UI.
  - **Controller/Repository (Simplified)**: "Database" classes (`BDVuc`, `BDToco`) that manage the in-memory object collections and contain business logic.
- **On-Demand UI Updates**: Reports are repopulated via the `atualizarTabela()` method, which is explicitly called before displaying the window, ensuring data is always synchronized.

## Screenshots

> **Note:** Create a folder named `assets` or `docs/images` in your project's root directory and place your screenshots there. Then, update the file paths below accordingly.

| Main Window | VUC Registration |
| :---: | :---: |
| ![Main Window](assets/main-window.png) | ![VUC Registration Form](assets/form-vuc.png) |

| Toco Report | Truck Report |
| :---: | :---: |
| ![Toco Report](assets/report-toco.png) | ![Truck Report](assets/report-truck.png) |

## Technologies Used

- **Java SE 11+**
- **Java Swing** for the graphical user interface.
- **NetBeans IDE 12+** with its GUI Builder.

## Getting Started

### Prerequisites

- **JDK 8** or higher installed.
- **Apache NetBeans** (recommended for opening the project and viewing the UI design).

### Running the Project

1. **Clone the repository:**
   ```bash
   git clone https://github.com/ricardomarchezan/TruckSystemRegister.git
2. **Open in NetBeans:**
   - Go to `File > Open Project` and select the cloned project folder.
3. **Clean and Build:**
   - Right-click on the project in the Projects pane and select `Clean and Build`.
4. **Run:**
   - Locate the `FormPrincipal.java` file.
   - Right-click on it and choose `Run File`.

---


---

## Future Roadmap

- [ ] **Data Persistence**: Migrate from in-memory storage to a database (SQLite, H2) using JDBC.
- [ ] **Report Exporting**: Add functionality to export tables to formats like CSV or PDF.
- [ ] **Unit Testing**: Implement tests with JUnit for the model and repository classes.
- [ ] **Filtering and Sorting**: Add search filters and column-sorting capabilities to the report tables.
- [ ] **UI/UX Enhancements**: Implement input masks (e.g., for license plates) and a more modern Look & Feel.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Author

Made by **RicardoMarchezan**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-RicardoMarchezan-blue)](https://www.linkedin.com/in/ricardo-marchezan-801808288/)
[![GitHub](https://img.shields.io/badge/GitHub-ricardomarchezan-black)](https://github.com/ricardomarchezan)



