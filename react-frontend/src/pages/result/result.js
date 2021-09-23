import React, { useState ,useEffect } from 'react';
import instance from '../../config/axios';

const Result = () =>{
    const [unSoldPlayers,setUnsoldPlayers] = useState(null);
    
    useEffect(() => {
        //change
        console.log("Inside unsold");
        instance.get("/getPlayersList").then((response)=>{
           let unsold = [];
           for(var i =0;i<response.data.length;i++){
               if(response.data[i].sold === false){
                   unsold.push(response.data[i]);
               }
           }
            console.log(unsold);
            setUnsoldPlayers(unsold);
        }).catch((error)=>{
            console.log(error);
        });
        console.log("getting out");

    }, []);

    return(
        <div>
            <br/>
            <div className = "row">
                <table className = "table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th> Player ID </th>
                            <th> Player Name </th>
                            <th> Base Price </th>
                            <th> Cumulative Rating </th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            unSoldPlayers?
                            unSoldPlayers.map((player,index)=>{
                                return(
                                <tr key ={index}>
                                    <td>{   player.playerid}</td>
                                    <td> {  player.playername} </td>   
                                    <td> {  player.base}</td>
                                    <td> {  player.cumulativerating } </td>
                                </tr>
                                );
                            })
                            :null
                            
                        }
                    </tbody>
                </table>
                </div>
                <br/>
        </div>
    );
}

export default Result;