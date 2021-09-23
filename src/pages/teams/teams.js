import React, { useRef, useState ,useEffect} from 'react';
import instance from '../../config/axios';

const Team = () =>{
    // var unSoldPlayerDetails = [
    //     {playerid:1,playername:"Tanisha",base:100,bid:0,sold:false,cumulativerating:4},
    //     // {playerid:2,playername:"Tambi",base:50,bid:0,sold:true,cumulativerating:4},
    //     {playerid:3,playername:"Rishab",base:110,bid:0,sold:false,cumulativerating:4},
    //     // {playerid:4,playername:"Abhishek",base:20,bid:0,sold:true,cumulativerating:4},
    //     {playerid:1,playername:"Shubhi",base:90,bid:0,sold:false,cumulativerating:4},
    // ];

    const [unSoldPlayerDetails,setUnsoldPlayerDetails] = useState(null);
    const teamID = useRef(null);
    const BidPrice = useRef(null);
    let highestBid = 0;
    let teamIDHighest =0;

    const [index,setIndex] = useState(0); 

    const startTimer=(duration, display)=>{
        var timer = duration, minutes, seconds;
        setInterval(function () {
            minutes = parseInt(timer / 60, 10);
            seconds = parseInt(timer % 60, 10);
    
            minutes = minutes < 10 ? "0" + minutes : minutes;
            seconds = seconds < 10 ? "0" + seconds : seconds;
    
            display.textContent = minutes + ":" + seconds;
    
            if (--timer < 0) {
                timer = duration;
            }
        }, 1000);
    }
    const updateIndex =() =>{
        console.log('highestBid = '+ unSoldPlayerDetails[index].bid + " ID : "+teamIDHighest);
        //change
        // instance.post("/xyz",{
        //     playerid:unSoldPlayerDetails[index].playerid,
        //     teamID:teamIDHighest,
        //     bid:unSoldPlayerDetails[index].bid
        // }).then((response)=>{
        //     alert(response.data);
        // }).catch((error)=>{
        //     console.log(error);
        // });

        if(index<unSoldPlayerDetails.length){
            let x = index+1
            setIndex(x);
        }
        BidPrice.current.value = null;
        teamID.current.value =null;
    }
    useEffect(()=>{
        getUnsoldPlayer();
    },[]);

    window.onload = function () {
        var fiveMinutes = 60 * 1,
            display = document.querySelector('#time');
        startTimer(fiveMinutes, display);
        setInterval(updateIndex,1000*60*1);
    };
    
    const getUnsoldPlayer = () =>{
        //change
        instance.get("/getPlayersList")
        .then((response)=>{
            let unsold = response.data.filter(function(e){
                return e.sold = false;
            });
            setUnsoldPlayerDetails(unsold);
        }).catch((error)=>{
            console.log(error);
        });
    }

    const checkHighest = (e) =>{
        e.preventDefault();
        if(BidPrice.current.value > unSoldPlayerDetails[index].bid){
            unSoldPlayerDetails[index].bid = BidPrice.current.value;
            teamIDHighest = teamID.current.value;
        }else{
            alert("Please Bid More Than the Already Highest");
            BidPrice.current.value=0;
        }
    }

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
                            <th> Hightest Bid </th>
                            <th> Cumulative Rating </th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            unSoldPlayerDetails?
                            <tr >
                                <td>{   unSoldPlayerDetails[index].playerid}</td>
                                <td> {  unSoldPlayerDetails[index].playername} </td>   
                                <td> {  unSoldPlayerDetails[index].base}</td>
                                <td> {  unSoldPlayerDetails[index].bid }</td>
                                <td> {  unSoldPlayerDetails[index].cumulativerating } </td>
                            </tr>
                            :null
                        }
                    </tbody>
                </table>
                </div>
                <br/>
            <div className = "container">
                <div className = "row">
                    <div className = "card col-md-6 offset-md-3 offset-md-3">
                        <h3 className="text-center">Update/Add Base Price</h3>
                        <div className = "card-body">
                            <form>
                                <div className = "form-group">
                                    <label> Team ID: </label>
                                    <input placeholder="Team ID" name="TeamID" className="form-control" 
                                        ref={teamID}  />
                                </div>
                                <div className = "form-group">
                                    <label> Bid Price:(in Lakhs) </label>
                                    <input placeholder="Enter Your BID Price" name="BIDPrice" className="form-control" 
                                        ref={BidPrice}  />
                                </div>
                                <br/>
                                <button className="btn btn-success" onClick={checkHighest}>Save</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div>Registration closes in <span id="time">1:00</span> minutes!</div>
            </div>     
        </div>
    );
}

export default Team;