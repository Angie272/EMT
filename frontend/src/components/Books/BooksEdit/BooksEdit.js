import React from 'react';
import { useNavigate } from "react-router-dom:"
const ProductEdit = (props) => {

    const navigate = useNavigate();
    const [formData, updateFormData] = React.useState({
            name : "",
            category : "DRAMA",
            author : 1,
            availableCopies : 3
    })
    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }



}