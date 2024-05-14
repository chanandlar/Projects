
import { useState } from "react";
import "./Counter.css"
import PropTypes from 'prop-types';

export default function Counterr(){
    const [count,setcount]=useState(0);

    function incrementCounterParentFunction(by){
        setcount(count+by);
    }

    function decrementCounterParentFunction(by){
        setcount(count-by);
    }

    function resetCounter(){
        setcount(0);
    }


    return(
        <>
            <span className="totalcount">{count}</span>
            <Counter by={1} incrementMethod={incrementCounterParentFunction} decrementMethod={decrementCounterParentFunction}/>
            <Counter by={2} incrementMethod={incrementCounterParentFunction} decrementMethod={decrementCounterParentFunction}/>
            <Counter by={5} incrementMethod={incrementCounterParentFunction} decrementMethod={decrementCounterParentFunction}/>
            <button className="ResetButton" onClick={resetCounter}>Reset</button>
        </>
    )
}


function Counter({by,incrementMethod,decrementMethod}){

  

    return (
        <>
            <div className="Counter">
                <button className="counterButton" 
                        onClick={()=>incrementMethod(by)}
                >+{by}</button>
                <button className="counterButton" 
                        onClick={()=>decrementMethod(by)}
                >-{by}</button>
            </div>
        </>
    )
}

Counter.propTypes={
    by:PropTypes.number
}

Counter.defaultProps={
    by:1
}