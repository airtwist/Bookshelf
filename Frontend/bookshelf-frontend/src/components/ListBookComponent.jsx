import React, {useEffect, useState} from 'react'
import { listOfBooks } from '../services/BookService'
import { useNavigate } from 'react-router-dom'
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';

const ListBookComponent = () => {

    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const [books, setBooks] = useState([])

    const navigator = useNavigate();

    useEffect(()=>{
        listOfBooks().then((response)=>{
            setBooks(response.data)
        }).catch(error=>{
            console.error(error);
        })
    },[] )

    function addNewBook(){
        navigator('add-book')
    }

  return (
    <div className='container'>
        <h2 className='text-center'>List of books</h2>
        <table className='table table-striped table-bordered'>
            <thead className="thead-dark">
                <tr>
                    <th>Book id</th>
                    <th>Book Title</th>
                    <th>Book Author</th>
                    <th>Book Rating</th>
                    <th>Book Review</th>
                </tr>
            </thead>
            <tbody>
                {   
                    books.map(book =>
                        <tr key={book.id}> 
                            <td>{book.id}</td>
                            <td>{book.title}</td>
                            <td>{book.author}</td>
                            <td>{book.rating}</td>
                            <td>{book.review}</td>
                        </tr>)
                }
        
            </tbody>
        </table>
        <button className='btn btn-primary mb2' onClick={addNewBook}>Add Book</button>

        <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Modal heading</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
              <Form.Label>Email address</Form.Label>
              <Form.Control
                type="email"
                placeholder="name@example.com"
                autoFocus
              />
            </Form.Group>
            <Form.Group
              className="mb-3"
              controlId="exampleForm.ControlTextarea1"
            >
              <Form.Label>Example textarea</Form.Label>
              <Form.Control as="textarea" rows={3} />
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary" onClick={handleClose}>
            Save Changes
          </Button>
        </Modal.Footer>
      </Modal>
    </div>
  )
}

export default ListBookComponent