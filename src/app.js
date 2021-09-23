import React from 'react';
import HeaderComponent from './component/HeaderComponent';
import { BrowserRouter as Router, Switch, Route  } from 'react-router-dom'
import Player from './pages/players/players';
import Team from './pages/teams/teams';
import Result from './pages/result/result';
import Home from './pages/Home/home';
import TeamResult from './pages/result/teamRes';

const App = () =>{
    return(
        <div>
            <HeaderComponent/>
            <Router>
                <Switch>
                    <Route exact path="/">
                        <Home/>
                    </Route>
                    <Route path="/player" >
                        <Player/>
                    </Route>
                    <Route path="/team" >
                        <Team/>
                    </Route>
                    <Route path="/result" >
                        <Result/>
                    </Route>
                    <Route path="/teamresult" >
                        <TeamResult/>
                    </Route>
                </Switch>
            </Router>
        </div>
    );
}

export default App;