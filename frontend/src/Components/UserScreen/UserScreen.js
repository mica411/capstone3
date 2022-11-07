import { Component } from 'react'
import {Link} from 'react-router-dom'
import {connect} from 'react-redux'
import {withRouter} from 'react-router-dom'
import {addToken, addUser} from '../../Redux/actionCreators'
import {baseUrl} from '../../Shared/baseUrl'
import axios from 'axios'
import { func } from 'prop-types'

function userScreen(){
    return (
        <div id="userScreenDiv">
            <div>
                <div id="userOnline"></div>
                <div id="screenDiv">
                    <img src=""/>
                    <div id="screenDivInfo">
                            Restaurants Details <br/>
                            name, address, link, others...
                    </div>
                </div>
                <div id="dineDashButtons">
                <button>Dine</button>
                <button>Dash</button>
                </div>
            </div>
        </div>
    )
}

export default userScreen;