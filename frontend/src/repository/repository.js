import axios from "../custom-axios/axios";

const LibrarianService = {

    fetchBooks: () => {
        return axios.get("/book");
    },
    fetchCategories: () => {
        return axios.get("/book/categories");
    },
    fetchAuthors: () => {
        return axios.get("/author");
    },
    fetchCountries: () => {
        return axios.get("/country");
    },
    deleteBook: (id) => {
        return axios.delete(`/book/delete/${id}`);
    },
    addBook: (name, category, author, availableCopies) => {
        return axios.post("/book/save", {
            "name" : name,
            "category" : category,
            "author" : author,
            "availableCopies" : availableCopies
        });
    },
    editBook: (id, name, category, author, availableCopies) => {
        return axios.put(`/book/edit/${id}`, {
            "name" : name,
            "category" : category,
            "author" : author,
            "availableCopies" : availableCopies
        });
    },
    getBook: (id) => {
        return axios.get(`/book/${id}`);
    },

    markBook : (id) => {
        return axios.put(`/book/takeBook/${id}`);
    }


}

export default LibrarianService;
