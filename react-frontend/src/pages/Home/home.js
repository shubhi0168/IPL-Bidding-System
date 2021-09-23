import React, {} from 'react';
import { Link } from 'react-router-dom';

const Home = () => {

    return (
        <div>
            <Link to="/player" >
                <button className="btn btn-primary" onClick={()=>{}}> For Players </button>
            </Link>
            <Link to ="/team">
                <button className="btn btn-primary" onClick={()=>{}}> For Teams </button>
            </Link>
            <Link to ="/result">
                <button className="btn btn-primary" onClick={()=>{}}> Unsold Result </button>
            </Link >
            <Link to ="/teamresult">
                <button className="btn btn-primary" onClick={()=>{}}> Team Result </button>
            </Link >
        </div>
    );
}
export default Home;