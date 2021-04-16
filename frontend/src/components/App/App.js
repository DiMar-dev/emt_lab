import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom';
import Header from "../Header/header"
import Books from "../Books/book";
import Categories from "../Categories/category";
import LibrarianService from "../../repository/repository";
import AddBook from "../Books/addBook/addBook";
import EditBook from "../Books/editBook/editBook";

class App extends Component{

    constructor(props) {
        super(props);
        this.state={
            books: [],
            categories: [],
            authors: [],
            countries: [],
            selectedBook: {}
        }
    }

    render() {
        return(
            <Router>
                <Header/>
                <main>
                    <div>
                        <Route path={"/categories"} exact render={() =>
                            <Categories categories={this.state.categories}/>}/>

                        <Route path={"/book/add"} exact render={() =>
                            <AddBook categories={this.state.categories}
                                        authors={this.state.authors}
                                        onAddBook={this.addBook}/>}/>

                        <Route path={"/book/edit/:id"} exact render={() =>
                            <EditBook categories={this.state.categories}
                                      authors={this.state.authors}
                                      onEditBook={this.editBook}
                                      book={this.state.selectedBook}/>}/>

                        <Route path={"/home"} exact render={() =>
                            <Books books={this.state.books}
                                   onDelete={this.deleteBook}
                                   onEdit={this.getBook}
                                   markBook={this.markBook}/>}/>

                        <Route path={"/"} exact render={() =>
                            <Books books={this.state.books}
                                   onDelete={this.deleteBook}
                                   onEdit={this.getBook}
                                   markBook={this.markBook}/>}/>
                    </div>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        this.loadBooks();
        this.loadCategories();
        this.loadAuthor();
        this.loadCountries();
    }

    loadBooks = () => {
        LibrarianService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            });
    }

    loadCategories = () => {
        LibrarianService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }

    loadAuthor = () => {
        LibrarianService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            });
    }

    loadCountries = () => {
        LibrarianService.fetchCountries()
            .then((data) => {
                this.setState({
                    countries: data.data
                })
            });
    }

    deleteBook = (id) => {
        LibrarianService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            });
    }

    addBook = (name, category, author, availableCopies) => {
        LibrarianService.addBook(name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    editBook = (id, name, category, author, availableCopies) => {
        LibrarianService.editBook(id, name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    getBook = (id) => {
        LibrarianService.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            })
    }

    markBook = (id) => {
        LibrarianService.markBook(id)
            .then(() => {
                this.loadBooks();
            });
    }

}

export default App;
