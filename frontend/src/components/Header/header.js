import React from "react";
import {Link} from "react-router-dom";


const  Header  = () => {
    return (
        <header>
            <nav>
                <div>
                    <ul>
                        <li><Link to={'/books'}>Books</Link></li>
                        <li><Link to={'/authors'}>Authors</Link></li>
                        <li><Link to={'/categories'}>Categories</Link></li>
                    </ul>
                </div>
            </nav>
        </header>
    )
}

export default Header;