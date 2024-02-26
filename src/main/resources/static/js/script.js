$(document).ready(function () {
    $.get( "http://localhost:8080/api/books", function( data ) {

        let books = ``;
        data.forEach(book=>{
            let bookHtml = ` <tr>
            <th scope="row">${book.id}</th>
            <td>${book.author}</td>
            <td>${book.title}</td>
            <td>${book.cover}</td>
            <td>${book.review}</td>
            <td>${book.rating}</td>
            </tr>`;
        books+=bookHtml;
        });

        $( "#bookshelf" ).html( books );
        alert( "Load was performed." );
    });
})