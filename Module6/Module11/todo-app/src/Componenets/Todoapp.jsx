import { useState } from "react"
import {BrowserRouter, Routes, Route, useNavigate, useParams, Link} from 'react-router-dom'


export default function Todoapp(){
    return(
        <div className="Todoapp">
            <HeaderComponent/>
            <BrowserRouter>
                <Routes>
                    <Route path='/' element={<LoginComponent/>}></Route>
                    <Route path='/login' element={<LoginComponent/>}></Route>
                    <Route path='/welcome/:username' element={<WelcomeComponent/>}></Route>
                    <Route path='/todos' element={<ListTodosComponent/>}></Route>
                    <Route path='*' element={<ErrorComponent/>}></Route>
                </Routes>
            </BrowserRouter>
            <FooterComponent/>
            {/*<WelcomeComponent/>*/}
        </div>
    )
}

function LoginComponent(){
    const [username, setUsername]=useState('in28minutes')
    const [password, setPassword]=useState('')
    const [showSuccessMessage, setSuccessMessage]=useState(false)
    const [showErrorMessage, setErrorMessage]=useState(false)
    
    const navigate=useNavigate();

    function handleUsernameChange(event){
        setUsername(event.target.value);
    }

    function handlePasswordChange(event){
        setPassword(event.target.value)
    }



    function handleSubmit(){
        if(username==='in28minutes' && password==='test'){
            console.log("Success");
            setSuccessMessage(true);
            navigate(`/welcome/${username}`)
        }else{
            console.log('Failed');
            setErrorMessage(true);
        }
    }

    function SuccessMessageComponent(){
        if(showSuccessMessage){
            return(
                <div className="successMessage" >Authentication successful</div>
            )

        }else{
            return null;
        }
    }

    function ErrorMessageComponent(){
        if(showErrorMessage){
            return(
                <div className="errorMessage" >Authentication failed</div>
            )
        }else{
            return null;
        }
    }


    return(
        <div className="Login">
            <SuccessMessageComponent/>
            <ErrorMessageComponent/>
            Login Component
            <div className="LoginForm">
                <div>
                    <label>User Name</label>
                    <input type="text" name="Username" value={username} onChange={handleUsernameChange}></input>
                </div>
                <div>
                    <label>Password</label>
                    <input type="password"></input>
                </div>
                <div>
                    <button type="button" name="login" onChange={handlePasswordChange} onClick={handleSubmit}> Login </button>
                </div>
            </div>
        </div>
    )
}



function WelcomeComponent(){
    const {username}=useParams();
    console.log(username);
    return(
       
        <div className="Welcome">
            Welcome Component
        </div>
    )
}

function ErrorComponent(){
    return(
        <div className="ErrorComponent">
            <h1>We are working really hard</h1>
            <div>
                Apologies for the 404
            </div>
        </div>
    )
}

function ListTodosComponent(){
    const today=new Date();
    const target=new Date(today.getFullYear+12,today.getMonth,today.getDay);
    const todos=[{id:1,description:'Learn AWS',done:false,targetDate:target},
    {id:1,description:'Full Stack',done:false,targetDate:target},
    {id:1,description:'Spring Boot',done:false,targetDate:target}]


    return(
        <div className="ListTodosComponent">
            <h1>Things you want to do</h1>
            <div>
                <table>
                    <thead>
                        <tr>
                            <td>Id</td>
                            <td>Description</td>
                            <td>Done</td>
                            <td>Target</td>
                        </tr>
                    </thead>
                    <tbody>
                    <tr>
                            <td>{todos.id}</td>
                            <td>{todos.description}</td>
                            <td>{todos.done}</td>
                            <td>{todos.targetDate.toDateString()}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    )
}

function HeaderComponent(){
    return(
        <header className="header">
           <div className="container">
            <ul className="navbar-nav">
                <li className="nav-item"><a className="nav-link" href="https://www.in28minutes.com">in28minutes</a></li>
                
                <li className="nav-item"><Link className="nav-link" to="/welcome/shoeb">Home</Link></li>
                
                <li className="nav-item"><a href="/todos">Todos</a></li>

                <li className="nav-item"><Link className="nav-link" to="/login">Login</Link></li>
            </ul>
               
           </div>
        </header>
    )
}

function FooterComponent(){
    return(
        <footer className="footer">
           <div className="container">
                Footer
           </div>
        </footer>
    )
}