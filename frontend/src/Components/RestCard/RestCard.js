import React from "react";

export default function RestCard(props) {

    return (
        
        <div className="">
            <h5 className="">{props.restaurantName}</h5>
            <div>{props.cuisineType}</div>
            <div>{props.phoneNumber}</div>
            <div>{props.streetAddress}</div>
            <div>{props.state}</div>
            <div>{props.zipCode}</div>
        </div>
    )
}

// key: item.resId,
// resId: item.resId,
// city: item.city,
// cuisineType:item.cuisineType,
// phoneNumber: item.phoneNumber,
// restaurantName: item.restaurantName,
// state: item.state,
// streetAddress: item.streetAddress,
// zipCode: item.zipCode