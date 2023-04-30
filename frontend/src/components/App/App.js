
import './App.css';
import {Component} from "react";
import Header from "../Header/header";

class App extends Component{
  constructor(props) {
    super(props)
    this.state= {
      books: [],
      authors: [],
      categories: [],
      countries: [],
      selectedBook:{}

    }

  }
  render(){

    return(
        <Router>
          <Header/>
          <main>
            <Routes>
              Route path={"/categories"} exact render={() =>
                <Categories categories={this.state.categories}/>}/>
              <Route path={"/books/add"} exact render={() =>
                  <BookAdd categories={this.state.categories}
                           authors={this.state.authors}
                           onAddBook={this.addBook}/>}/>



            </Routes>


          </main>

        </Router>

    )

  }

  componentDidMount() {
  }
}

export default App;
