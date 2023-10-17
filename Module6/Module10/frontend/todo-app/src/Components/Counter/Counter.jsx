
import { useState } from "react";
import "./Counter.css"

export default function Counter(){

    const [count,setcount]=useState(0);

    function incrementCounterFunction(){
        setcount(count+1);

        console.log(count);
    }

    function decrementCounterFunction(){
        setcount(count-1);

        console.log(count);
    }

    return (
        <>
            <div className="Counter">
                <span className="count">{count}</span>
                <button className="counterButton" 
                        onClick={incrementCounterFunction}
                >+1</button>
                <button className="counterButton" 
                        onClick={decrementCounterFunction}
                >-1</button>
            </div>
        </>
    )
}