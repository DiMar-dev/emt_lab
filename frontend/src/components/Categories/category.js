import React from "react";

const category = (props) => {

    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                {props.categories.map((term) => {
                    return (
                        <ul>
                            <li>{term}</li>
                        </ul>
                    );
                })}
            </div>
        </div>
    );

}

export default category;
