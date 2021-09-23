import React,{useEffect,useState} from 'react';
import instance from '../../config/axios';
const TeamResult= ()=>{
    const [team1,setTeam1] = useState(null);
    const [team2,setTeam2] = useState(null);
    const [team3,setTeam3] = useState(null);

    useEffect(() => {
        //change
        instance.get("/getPlayersList").then((response)=>{
            let t1 = response.data.filter(function(e){
                return e.teamid =1;
            });
            setTeam1(t1);

            let t2 = response.data.filter(function(e){
                return e.teamid =2;
            });
            setTeam2(t2);

            let t3 = response.data.filter(function(e){
                return e.teamid =3;
            });
            setTeam3(t3);
        });
    }, []);

    const ShowTeam =(name,arr)=>{
        return(
            <div>
                <br/>
                <h2>{name}</h2>
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
                            arr?
                            arr.map((player,index)=>{
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

    return(
        <div>
            {ShowTeam("Team 1",team1) }
            {ShowTeam("Team 2",team2) }
            {ShowTeam("Team 3",team3) }
            {/* <ShowTeam name="Team 2" arr={team2} />
            <ShowTeam name="Team 3" arr={team3} /> */}
        </div>
        );
}
export default TeamResult;