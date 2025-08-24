import React, { Component } from "react";

// we created a class component called MovieForm
class MovieForm extends Component {
  // constructor should runs first when the component is created
  constructor(props) {
    super(props); // call parent (Component) constructor to give values or inputs

    // Initialize state (all variables we need)
    this.state = {
      title: "", // movie title
      director: "", // movie director
      year: "", // release year
      genre: "Action", // already default selected genre
      rating: "", // movie rating
      description: "", // description text
      platforms: {
        // initially they are unchecked so thasy we gave false here
        Netflix: false,
        "Amazon Prime": false,
        "Disney+": false,
        Others: false,
      },
      movies: [], // its blank coz its an array to store submitted movies
      showForm: true, // it shows
    };

    console.log("constructor executed"); // lifecycle log its just to understand that constructer is being called in ui
  }

  // react lifecycle method - runs after constructor but before render
  static getDerivedStateFromProps(props, state) {
    //its a lifecycle method it strts after constructor and before render in both initial mount and updatemount
    //its used to update change
    //static means it cant use this.state or this.props
    console.log("getDerivedStateFromProps executed");
    return null; // no changes to state no updations is happeing
  }

  // react lifecycle method and it runs once after first render and also comonly used in fetching data from api
  componentDidMount() {
    console.log("componentDidMount executed");
  }

  // Decides whether component should re-render updatemount phase
  shouldComponentUpdate(nextProps, nextState) {
    console.log("shouldComponentUpdate executed");
    return true; // always re-render if it false means skip or block rerender
  }

  // Runs just before updating DOM
  getSnapshotBeforeUpdate(prevProps, prevState) {
    //its also a updatemount phase
    console.log("getSnapshotBeforeUpdate executed");
    return null; // no snapshot needed
  }

  // Runs after DOM is updated
  componentDidUpdate(prevProps, prevState, snapshot) {
    //its a updatemount phase
    console.log("componentDidUpdate executed");
  }

  // runs when component is removed (unmounted)
  componentWillUnmount() {
    //its a unmount phase
    console.log("componentWillUnmount executed");
  }

  // Handle text, number, textarea, select inputs
  handleChange = (e) => {
    // e.target.name → input name
    // e.target.value → input value
    this.setState({ [e.target.name]: e.target.value });
  };

  // Handle checkbox inputs
  handleCheckboxChange = (e) => {
    this.setState({
      platforms: {
        ...this.state.platforms, // keep old values and its a spread operator
        [e.target.name]: e.target.checked, // update clicked checkbox
      },
    });
  };

  // Handle form submit
  handleSubmit = (e) => {
    e.preventDefault(); // prevents the page reloading

    // destructure values from the state
    const { title, director, year, genre, rating, description, platforms } =
      this.state;

    // gets only selected platforms
    const selectedPlatforms = Object.keys(platforms).filter(
      (p) => platforms[p]
    ); //here this line of code collects only the platform names that are selected are true into an array.

    // Create a new movie object
    const newMovie = {
      title,
      director,
      year,
      genre,
      rating,
      description,
      platforms: selectedPlatforms,
    };

    // update movies array in state and reset form fields
    this.setState((prevState) => ({
      movies: [...prevState.movies, newMovie], // add new movie
      title: "", // reset all inputs
      director: "",
      year: "",
      genre: "Action",
      rating: "",
      description: "",
      platforms: {
        Netflix: false,
        "Amazon Prime": false,
        "Disney+": false,
        Others: false,
      },
    }));
  };

  // Toggle form visibility (used to test componentWillUnmount)
  //toggle form is button controlled switch it shows or hides
  toggleForm = () => {
    this.setState({ showForm: !this.state.showForm });
  };

  //it returns jsx
  render() {
    console.log("render executed"); // lifecycle log

    // Destructure values from state
    const {
      title,
      director,
      year,
      genre,
      rating,
      description,
      platforms,
      movies,
      showForm,
    } = this.state;

    return (
      <div>
        {/* Toggle button */}
        <button className="btn btn-secondary mb-3" onClick={this.toggleForm}>
          {showForm ? "Hide Form" : "Show Form"}
        </button>

        {/* Show form only if showForm is true */}
        {showForm && ( // conditional rendering above line
          <div className="card p-4">
            <h3>Add Movie</h3>
            <form onSubmit={this.handleSubmit}>
              {/* Movie Title */}
              <div className="mb-3">
                <label>Movie Title</label>
                <input
                  type="text"
                  className="form-control"
                  name="title"
                  value={title}
                  onChange={this.handleChange}
                />
              </div>

              {/* Director */}
              <div className="mb-3">
                <label>Director</label>
                <input
                  type="text"
                  className="form-control"
                  name="director"
                  value={director}
                  onChange={this.handleChange}
                />
              </div>

              {/* Release Year */}
              <div className="mb-3">
                <label>Release Year</label>
                <input
                  type="number"
                  className="form-control"
                  name="year"
                  value={year}
                  onChange={this.handleChange}
                />
              </div>

              {/* Genre */}
              <div className="mb-3">
                <label>Genre</label>
                <select
                  className="form-control"
                  name="genre"
                  value={genre}
                  onChange={this.handleChange}
                >
                  <option>Action</option>
                  <option>Comedy</option>
                  <option>Drama</option>
                  <option>Sci-Fi</option>
                  <option>Horror</option>
                </select>
              </div>

              {/* Rating */}
              <div className="mb-3">
                <label>Rating</label>
                <div>
                  {[1, 2, 3, 4, 5].map((num) => (
                    <label key={num} className="me-2">
                      <input
                        type="radio"
                        name="rating"
                        value={num}
                        checked={rating === String(num)} //it makes sure only the radio button that matches the selected rating is shown as selected.
                        onChange={this.handleChange}
                      />{" "}
                      {num}
                    </label>
                  ))}
                </div>
              </div>

              {/* Description */}
              <div className="mb-3">
                <label>Description</label>
                <textarea
                  className="form-control"
                  name="description"
                  value={description}
                  onChange={this.handleChange}
                />
              </div>

              {/* Platforms */}
              <div className="mb-3">
                <label>Available on Streaming Platforms</label>
                <div>
                  {Object.keys(platforms).map((platform) => (
                    <label key={platform} className="me-3">
                      <input
                        type="checkbox"
                        name={platform}
                        checked={platforms[platform]}
                        onChange={this.handleCheckboxChange}
                      />{" "}
                      {platform}
                    </label>
                  ))}
                </div>
              </div>

              {/* Submit button */}
              <button type="submit" className="btn btn-primary">
                Add Movie
              </button>
            </form>
          </div>
        )}

        {/* Table of Movies */}
        {movies.length > 0 && (
          <table className="table mt-4">
            <thead>
              <tr>
                <th>Title</th>
                <th>Director</th>
                <th>Release Year</th>
                <th>Genre</th>
                <th>Rating</th>
                <th>Available on Streaming Platforms</th>
              </tr>
            </thead>
            <tbody>
              {movies.map((movie, index) => (
                <tr key={index}>
                  <td>{movie.title}</td>
                  <td>{movie.director}</td>
                  <td>{movie.year}</td>
                  <td>{movie.genre}</td>
                  <td>{movie.rating}</td>
                  <td>{movie.platforms.join(", ")}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    );
  }
}

// Export MovieForm so App.js can use it
export default MovieForm;