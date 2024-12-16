# Speechify Android UI Test


## Project Overview

Welcome to the Digital Book Library Android app project! Follow the guidelines below to ensure a smooth development process and meeting project requirements.

---

## Problem Statement

Develop an Android application that serves as a digital book library. The application should consist of two main components: **`BookListFragment`** and **`BookDetailsFragment`**. The **`BookListFragment`** will display a list of books retrieved from the **`BookRepository`**. **`BookRepository`** has been implemented for you. Upon selecting a book, the application should navigate to the **`BookDetailsFragment`**, which displays detailed information about the selected book.

### Task Details —

-   [ ] Implement `BookListFragment` to display books. Make each book item in the list clickable.
-   [ ] Implement `BookDetailsFragment` to display the details of the selected book.
-   [ ] Implement navigation logic from `BookListFragment` to `BookDetailsFragment`.

### Time to Implement —

45 minutes.

### Components Provided —

1. **BookListFragment**:
    - A Fragment that displays a list of books.
    - Fetch the list of books from the **`BookRepository`**.
    - On tapping a book item, navigate to the **`BookDetailsFragment`** with the selected book's details.
2. **BookDetailsFragment**:
    - A Fragment that shows detailed information about the selected book.
    - Display book attributes such as title, author, and a the cover image.
3. **BookRepository**:
    - A class that abstracts the data layer of the application.
    - Provides methods to retrieve book data (e.g., a list of books, details of a specific book).
4. **Book**:
    - A data class representing a book with attributes like title, author, description, etc.
5. **HomeActivity**:
    - The main Activity of the application which hosts the Fragments.
6. **XML Layout Files**:
    - **`fragment_book_details.xml`**: Layout for **`BookDetailsFragment`**.
    - **`activity_home.xml`**: Layout for **`HomeActivity`**.
    - **`fragment_book_list.xml`**: Layout for **`BookListFragment`**.
    - **`item_book.xml`**: Layout for each item in the book list.
    - **`nav_graph.xml`**: Navigation file being used in **`HomeActivity`**.

---

## Development Guidelines

-   Ensure the UI is responsive and adheres to Material Design principles.
-   Write clean, maintainable, and well-documented code.
-   **DO NOT MODIFY `BookRepository`.**
-   Feel free to modify all XML files as needed.
-   Feel free to modify all Fragment and Activity classes as needed.
-   Add any additional classes/files as needed.
-   Do not add/use any external library.
