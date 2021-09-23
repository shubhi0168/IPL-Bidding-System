import React,{useRef, useState} from 'react';
import instance from '../../config/axios';
import {useHistory} from 'react-router-dom';

const Player = () =>{
    const playerID = useRef(null);    
    const basePrice = useRef(null);
    const history = useHistory(null);

    const updateBasePrice = (e) =>{
        //change
        e.preventDefault();
        var id = playerID.current.value;
        var baseP = parseInt(basePrice.current.value);
        if( baseP<10 || baseP > 200){
            alert("Enter the valide Base Price");
            basePrice.current.value =null;
        }else{
            alert('Success if server is working');
            // instance.post("/xyz",{playerid:id,base:baseP})
            // .then((response)=>{
            //     alert(response.data);
            // }).catch((error)=>{
            //     console.log(error);
            // });
            history.push("/");
        }
        
    }
    const CancelBtn = ()=>{
        history.push("/");
    }


    return(
        <div>
            <br/>
            <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update/Add Base Price</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Player ID : </label>
                                            <input placeholder="Player ID" name="playerID" className="form-control" 
                                                ref={playerID} />
                                        </div>
                                        <div className = "form-group">
                                            <label> Base Price:(10-200)(in Lakhs) </label>
                                            <input placeholder="Enter Your Base Price" name="basePrice" className="form-control" 
                                                ref={basePrice} />
                                        </div>
                                        <br/>
                                        <button className="btn btn-success" onClick={updateBasePrice}>Save</button>
                                        <button className="btn btn-danger" onClick={CancelBtn} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                   </div>
        </div>
    );
}

export default Player;