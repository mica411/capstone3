import { Component } from 'react'
import {Link} from 'react-router-dom'
import {connect} from 'react-redux'
import {withRouter} from 'react-router-dom'
import {addToken, addUser} from '../../Redux/actionCreators'
import {baseUrl} from '../../Shared/baseUrl'
import axios from 'axios'



const mapDispatchToProps = (dispatch) => ({
    addToken: () =>  dispatch(addToken()),
    addUser: () => dispatch(addUser()) 
});

class Login extends Component {
    
    constructor(props){
        super(props);
        this.state = {
            username: '',
            password: ''
        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleGuest = this.handleGuest.bind(this);
    }
    

    handleLogin = async () => {
        const data = { username: this.state.username, password: this.state.password };
        

        const userWithToken = await axios.post(baseUrl + '/login', data)

        
        await this.props.dispatch(addToken(userWithToken.data.token))
        await this.props.dispatch(addUser(userWithToken.data.user));
    }

    handleGuest = () => {

    }

    handleInputChange = (event) => {
        event.preventDefault()
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    render(){
        return(
            <div id="intDiv">
                <div id="formDiv">
                    <label className="sr-only">Username</label>
                    <input
                        type="text"
                        id="username"
                        name="username"
                        className="form-control"
                        placeholder="Username"
                        v-model="user.username"
                        onChange={this.handleInputChange}
                        required
                    />
                    <label className="sr-only">Password</label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        className="form-control"
                        placeholder="Password"
                        v-model="user.password"
                        onChange={this.handleInputChange}
                        required
                    />
                    <div id="formSubMenu">
                        <Link to="/register">Not a Member Yet? Register!</Link>
                        <Link to="/register">Forgot Password?</Link>
                    </div>
                    <button type="submit" onClick={this.handleLogin}>Sign in</button>
                    <br/>
                    <button type="submit" style={{backgroundColor:'blue'}}>Login As Guest</button>
            </div>
            </div>
        )
    }
}

export default withRouter(connect(mapDispatchToProps)(Login));