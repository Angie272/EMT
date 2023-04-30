import React from "react";
import { useNavigate } from "react-router-dom";
const BookAdd = (props) => {
    const navigate = useNavigate();
    const [formData, updateFormData] = React.useState({
        name : "",
        category : "DRAMA",
        author : 1,
        availableCopies : 3
      })
}
const handleChange = (e) => {
    updateFormData({
        ...formData,
        [e.target.name] : e.target.value.trim()
    })

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name;
        const category = formData.category;
        const author = formData.author;
        const availableCopies = formData.availableCopies;

        props.onAddBook(name, category, author, availableCopies);
        navigate('/books');
    }
}



