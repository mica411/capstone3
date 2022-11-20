import {Component} from 'react'
import {Switch, Route, Redirect, Link} from 'react-router-dom'
import Login from '../Login/Login'
import Register from '../Register/Register'
import Home from '../Home/Home'
import Guest from '../Guest/Guest'

import {addToken, deleteUser} from '../../Redux/actionCreators'
import {connect} from 'react-redux'
import {withRouter} from 'react-router-dom'

const mapStateToProps = state => {
    return {
        token: state.token,
        user: state.user
    }
}

const mapDispatchToProps = (dispatch) => ({
    addToken: () => { dispatch(addToken()) },
    deleteUser: () => { dispatch(deleteUser())}
});

class Main extends Component {
    constructor(props){
        super(props);
        this.state = {
            
        }
    }

    handleLogout = () => {
        this.props.addToken("")
        this.props.deleteUser()
    }



    render(){
        return(
            <div>
                {(this.props.token.token !== undefined) ?
                        <div>

                            <Link to='/home' className='ui--buttons home'>Home</Link>
                            <Link to='/login' className='ui--buttons logout'onClick={this.handleLogout}>Logout</Link> 
                            <Redirect to='/home'/>

                        </div>  
                    : 
                        <Link to='/login' className='ui--buttons home'>Home</Link>
               }
                <Switch>
                    <Route path='/login' component={() => <Login/>}/>
                    <Route path='/register'component={() => <Register/>}/>
                    <Route path='/home' component={this.props.token.token !== undefined ? () => <Home/> : null}/>
                    {/* FIX IF TRUE LATER IN TERNARY 
                    <Route path='/user-screen' component={true ? () => <UserScreen/> : null}/>
                    */}
                    
                    <Redirect to='/login'/>
                </Switch>
            </div>
        )
    }
} 

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Main));