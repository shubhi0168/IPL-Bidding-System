import React,{useEffect,useState} from 'react';
import instance from '../../config/axios';
const TeamResult= ()=>{
    const [team1,setTeam1] = useState(null);
    const [team2,setTeam2] = useState(null);
    const [team3,setTeam3] = useState(null);
    const [t1,sett1] = useState(null);
    const [t2,sett2] = useState(null);
    const [t3,sett3] = useState(null);

    useEffect(() => {
        //change
        instance.get("/getResult").then((response)=>{
            console.log(response.data);
            let t1 = response.data.filter(function(e){
                return e.teamid =1;
            });
            setTeam1(response.data[0].players);
            sett1(response.data[0].teamname);

            let t2 = response.data.filter(function(e){
                return e.teamid =2;
            });
            setTeam2(response.data[1].players);
            sett2(response.data[1].teamname);

            let t3 = response.data.filter(function(e){
                return e.teamid =3;
            });
            setTeam3(response.data[2].players);
            sett3(response.data[2].teamname);
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
            {ShowTeam(t1,team1) }
            {ShowTeam("Team 2",team2) }
            {ShowTeam("Team 3",team3) }
            {/* <ShowTeam name="Team 2" arr={team2} />
            <ShowTeam name="Team 3" arr={team3} /> */}
        </div>
        );
}
export default TeamResult;