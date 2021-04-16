import React from "react";
import {Link} from 'react-router-dom';


const bookItem = (props) => {

    return (
        <tr>
            <td>{props.item.name}</td>
            <td>{props.item.author.name} {props.item.author.surname}</td>
            <td>{props.item.category}</td>
            <td>{props.item.availableCopies}</td>
            <td className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.item.id)}>
                    Delete
                </a>
                <Link className={"btn btn-info ml-2"}
                      onClick={() => props.onEdit(props.item.id)}
                      to={`/book/edit/${props.item.id}`}>
                    Edit
                </Link>
                <a title={"Mark a book"} className={"btn btn-warning"}
                   onClick={() => props.markBook(props.item.id)}>
                    Mark a book
                </a>
            </td>
        </tr>
    )

}

export default bookItem;
