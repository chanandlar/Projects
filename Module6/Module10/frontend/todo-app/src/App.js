
import './App.css';
import Counterr from './Components/Counter/Counter';

function App() {
  return (
    <div className="App ">
        <PlayingwithProps property1="value1" property2="value2"/>
        <Counterr/>
    </div>
  );
}

// function PlayingwithProps(properties){
//   console.log(properties);
//   console.log(properties.property1);
//   console.log(properties.property2);
//   return(
//     <div>Props</div>
//   )
// }

function PlayingwithProps({property1,property2}){
  console.log(property1);
  console.log(property2);
  return(
    <div></div>
  )
}


export default App;
