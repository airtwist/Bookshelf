import React, { useState } from 'react'

const BookComponent = () => {

   const [title, setTitle ] = useState('')
   const [author, setAuthor] = useState ('')
   const [rating, setRating] = useState ('')
   const [review, setReview] = useState('')

    
    function saveBook(e){
        e.preventDefault();

        const book = {title,author,rating,review}
        console.log(book)
    }

  return (
    <div className='container'>
        <br/> <br />
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                <h2 className='text-center'>Add Book</h2>
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label' > Title </label>
                            <input
                                type='text'
                                placeholder='Enter title of the book'
                                name='title'
                                value={title}
                                className='form-control'
                                onChange={(e) =>
                                    setTitle(e.target.value)}
                            >
                            </input>
                            
                        </div>
                        <div className='form-group mb-2'>
                            <label className='form-label' >Author</label>
                            <input
                                type='text'
                                placeholder='Enter author of the book'
                                name='author'
                                value={author}
                                className='form-control'
                                onChange={(e) =>
                                    setAuthor(e.target.value)}
                            >
                            </input>
                            
                        </div>
                        <div className='form-group mb-2'>
                            <label className='form-label' >Rating</label>
                            <input
                                type='text'
                                placeholder='Enter rating of the book'
                                name='rating'
                                value={rating}
                                className='form-control'
                                onChange={ (e) =>
                                    setRating(e.target.value)}
                            >
                            </input>
                            
                        </div>
                        <div className='form-group mb-2'>
                            <label className='form-label' >Review</label>
                            <input
                                type='text'
                                placeholder='Enter review of the book'
                                name='review'
                                value={review}
                                className='form-control'
                                onChange={(e) =>
                                    setReview(e.target.value)}
                            >
                            </input>
                            
                        </div>
                        <button className='btn btn-success' onClick={saveBook}> Submit</button>
                    </form>
                </div>

            </div>
        </div>
    </div>
  )
}

export default BookComponent