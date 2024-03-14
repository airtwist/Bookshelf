import axios from "axios"

const REST_API_BASE_URL= 'http://localhost:8080/api/books';

export const listOfBooks = () => axios.get(REST_API_BASE_URL);
