import axios from 'axios';
import React from 'react';
import { baseUrl } from '../../Shared/baseUrl';
import RestCard from '../RestCard/RestCard';


function Home() {

    const [restList, setRestList] = React.useState([]);

    function getRestList() {
        axios.get(baseUrl+"/api/restaurants")
            .then((res) => {

                const myList = res.data.map((item) => {

                    return {
                        resId: item.resId,
                        city: item.city,
                        cuisineType:item.cuisineType,
                        phoneNumber: item.phoneNumber,
                        restaurantName: item.restaurantName,
                        state: item.state,
                        streetAddress: item.streetAddress,
                        zipCode: item.zipCode
                    }
                    
                })

                console.log(myList)

                setRestList(myList)

                
        })

        
    }

    const myList = restList.map((item)=> 
        {
          return (<RestCard
            key = {item.resId}
            resId =  {item.resId}
            city = {item.city}
            cuisineType = {item.cuisineType}
            phoneNumber= {item.phoneNumber}
            restaurantName= {item.restaurantName}
            state={item.state}
            streetAddress= {item.streetAddress}
            zipCode= {item.zipCode}
          />)
        }
    )

    React.useEffect(()=>{getRestList()},[])

    

    

    return(
        <div>
            <h2>
                Restaurants
            </h2>
            {myList}

        </div>
        
    )

}

export default Home;

// React.useEffect(()=>{

    //     const getList = () => {
    //         axios.get(baseUrl+"/api/restaurants")
    //         .then((res) => {
    //         setRestList(res.data)
    //         console.log(restList)
    //         })
    //     }
        
        
    // },[test]);

/* return setRestList((prevList)=> {
        return [...prevList, {
            key: item.resId,
            resId: item.resId,
            city: item.city,
            cuisineType:item.cuisineType,
            phoneNumber: item.phoneNumber,
            restaurantName: item.restaurantName,
            state: item.state,
            streetAddress: item.streetAddress,
            zipCode: item.zipCode

        }]
    }) */

// cuisineType:"Ramen"
// days:null
// hours:null
// phoneNumber:"212-777-7773"
// resId:1
// restaurantName:"Momofuku Noodle Bar"
// state:"NY"
// streetAddress:"171 1st Ave"
// zipCode:10003
            
            //console.log(res.data);
            

// city:"New York"
// cuisineType:"Ramen"
// days:null
// hours:null
// phoneNumber:"212-777-7773"
// resId:1
// restaurantName:"Momofuku Noodle Bar"
// state:"NY"
// streetAddress:"171 1st Ave"
// zipCode:10003


// const [restList, setRestList] = React.useState([]);

//         function getRestList () { 
//             list = async () => {
//                 const list = await axios.get(baseUrl+"/api/restaurants");
//                 console.log(list.data);
//         } 
    

//         React.useEffect(()=>{getRestList},[])

//         return(
//             <div id="userScreenDiv">
//                 {/* <div>
//                     <div id="userOnline"></div>
//                     <div id="screenDiv">
//                         <img src=""/>
//                         <div id="screenDivInfo">
//                                 Restaurants Details <br/>
//                                 name, address, link, others...
//                         </div>
//                     </div>
//                     <div id="dineDashButtons">
//                     <button>Dine</button>
//                     <button>Dash</button>
//                     </div>
//                 </div> */}


//             </div>
//         )