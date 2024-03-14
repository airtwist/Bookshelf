import './App.css'
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import BookComponent from "./components/BookComponent";
import ListBookComponent from "./components/ListBookComponent";
import {BrowserRouter,Routes,Route} from 'react-router-dom'
import { useState } from 'react';


function App() {
  const [isOpen, setIsOpen] = useState(false)

  return (
    <>
    <BrowserRouter>
      <HeaderComponent/>
        <Routes>
        {/* // http://localhost:3000 */}
          <Route path='/' element = {<ListBookComponent/>}> </Route>
          {/* // http://localhost:3000/books */}
          <Route path='/books' element = {<ListBookComponent/>}> </Route>
           {/* // http://localhost:3000/add-book */}
           <Route path='/add-book' element = {<BookComponent/>}> </Route>
        </Routes>
      <FooterComponent/>
    </BrowserRouter>
    </>
  )
}

export default App
