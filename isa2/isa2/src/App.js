import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

import background from './images/pozadina.png';

import LoginComponent from './components/LoginComponent';

import IISOrganizatorProfilComponent from './components/IISOrganizatorProfilComponent.jsx';
import IISDogadjajiComponent from './components/IISDogadjajiComponent.jsx';
import IISViewSalaComponent from './components/IISViewSalaComponent.jsx';
import IISViewLjudskiResursiComponent from './components/IISViewLjudskiResursiComponent.jsx';
import IISViewOstaliResursiComponent from './components/IISViewOstaliResursiComponent.jsx';
import IISAddDogadjajComponent from './components/IISAddDogadjajComponent.jsx';
import IISIzmenaDogadjajaComponent from './components/IISIzmenaDogadjajaComponent.jsx';
import IISLjudskiResursiComponent from './components/IISLjudskiResursiComponent.jsx';
import IISAddLjudskiResursComponent from './components/IISAddLjudskiResursComponent.jsx';
import IISIzmenaLjudskihResursaComponent from './components/IISIzmenaLjudskihResursaComponent.jsx';
import IISOstaliResursiComponent from './components/IISOstaliResursiComponent.jsx';
import IISAddOstaliResursComponent from './components/IISAddOstaliResursComponent.jsx';
import IISIzmenaOstalihResursaComponent from './components/IISIzmenaOstalihResursaComponent.jsx';
import IISZahteviZaPrivatneComponent from './components/IISZahteviZaPrivatneComponent.jsx';
import IISZahtevModifikacijaComponent from './components/IISZahtevModifikacijaComponent.jsx';
import OrganizatorHeaderComponent from './components/OrganizatorHeaderComponent';
import IISVidiLjudskiComponent from './components/IISVidiLjudskiComponent.jsx';
import IISVidiOstaliComponent from './components/IISVidiOstaliComponent.jsx';
import IISZahteviResursaComponent from './components/IISZahteviResursaComponent.jsx';
import IISVidiDogadjajComponent from './components/IISVidiDogadjajComponent.jsx';


import IISGostHeaderComponent from './components/IISGostHeaderComponent';
import IISGostProfilComponent from './components/IISGostProfilComponent.jsx';
import IISGostDogadjajiComponent from './components/IISGostDogadjajiComponent.jsx';
import IISGostViewSalaComponent from './components/IISGostViewSalaComponent.jsx';
import IISGostSaleComponent from './components/IISGostSaleComponent.jsx';
import IISGostLjudskiResursiComponent from './components/IISGostLjudskiResursiComponent.jsx';
import IISGostOstaliResursiComponent from './components/IISGostOstaliResursiComponent.jsx';
import IISGostZahteviDogadjajaComponent from './components/IISGostZahteviDogadjajaComponent.jsx';
import IISGostZahteviModifikacijeComponent from './components/IISGostZahteviModifikacijeComponent.jsx';
import IISGostZahteviResursaComponent from './components/IISGostZahteviResursaComponent.jsx';
import IISGostZahtevLjudskiResursComponent from './components/IISGostZahtevLjudskiResursComponent.jsx';
import IISGostZahtevOstaliResursComponent from './components/IISGostZahtevOstaliResursComponent.jsx';
import IISGostVidiDogadjajComponent from './components/IISGostVidiDogadjajComponent.jsx';
import IISGostOrganizujDogadjajComponent from './components/IISGostOrganizujDogadjajComponent.jsx';

const backStyle = {
  width: '100%',
  height: '800px',
  backgroundImage: `url(${background})`,
  backgroundSize: 'cover' 
};


function headerDefinition(){

  if(localStorage.getItem('activeUser')==null){
    return(<div></div>)
  }
else{
  let activeUser = JSON.parse(localStorage.getItem('activeUser'))
    
  switch (activeUser.type) {    
    
      case 'organizator':    return(<OrganizatorHeaderComponent/>)   
      break;
      case 'gost':    return(<IISGostHeaderComponent/>)   
      break;
    default: 
      break;
  
  }
}

  
}


function App() {
  
  return (

    <div style={backStyle}> 
      
        <Router>
          
         {headerDefinition() } 
          <div className="container">
            <Switch> 
        
            <Route path = "/" exact component={LoginComponent}></Route>
              
            <Route path = "/organizatorprofil" component={IISOrganizatorProfilComponent}></Route>
            <Route path = "/dogadjaji" component={IISDogadjajiComponent}></Route>
            <Route path = "/sala" component={IISViewSalaComponent}></Route>
            <Route path = "/ljudskiresursidogadjaja" component={IISViewLjudskiResursiComponent}></Route>
            <Route path = "/ostaliresursidogadjaja" component={IISViewOstaliResursiComponent}></Route>
            <Route path = "/dodajdogadjaj" component={IISAddDogadjajComponent}></Route>
            <Route path = "/izmenadogadjaja" component={IISIzmenaDogadjajaComponent}></Route>
            <Route path = "/ljudskiresursi" component={IISLjudskiResursiComponent}></Route>
            <Route path = "/dodajljudskiresurs" component={IISAddLjudskiResursComponent}></Route>
            <Route path = "/izmenaljudskihresursa" component={IISIzmenaLjudskihResursaComponent}></Route>
            <Route path = "/ostaliresursi" component={IISOstaliResursiComponent}></Route>
            <Route path = "/dodajostaliresurs" component={IISAddOstaliResursComponent}></Route>
            <Route path = "/izmenaostalihresursa" component={IISIzmenaOstalihResursaComponent}></Route>
            <Route path = "/zahteviprivatni" component={IISZahteviZaPrivatneComponent}></Route>
            <Route path = "/zahtevimodifikacije" component={IISZahtevModifikacijaComponent}></Route>
            <Route path = "/vidiljudski" component={IISVidiLjudskiComponent}></Route>
            <Route path = "/vidiostali" component={IISVidiOstaliComponent}></Route>
            <Route path = "/zahteviresursa" component={IISZahteviResursaComponent}></Route>
            <Route path = "/vididogadjaj" component={IISVidiDogadjajComponent}></Route>


            <Route path = "/gostprofil" component={IISGostProfilComponent}></Route>
            <Route path = "/gostdogadjaji" component={IISGostDogadjajiComponent}></Route>
            <Route path = "/gostsala" component={IISGostViewSalaComponent}></Route>
            <Route path = "/gostvidiljudski" component={IISVidiLjudskiComponent}></Route>
            <Route path = "/gostvidiostali" component={IISVidiOstaliComponent}></Route>
            <Route path = "/gostsale" component={IISGostSaleComponent}></Route>
            <Route path = "/gostljudskiresursi" component={IISGostLjudskiResursiComponent}></Route>
            <Route path = "/gostostaliresursi" component={IISGostOstaliResursiComponent}></Route>
            <Route path = "/gostzahtevidogadjaja" component={IISGostZahteviDogadjajaComponent}></Route>
            <Route path = "/gostzahtevimodifikacije" component={IISGostZahteviModifikacijeComponent}></Route>
            <Route path = "/gostzahteviresursa" component={IISGostZahteviResursaComponent}></Route>
            <Route path = "/gostzahtevljudskiresurs" component={IISGostZahtevLjudskiResursComponent}></Route>
            <Route path = "/gostzahtevostaliresurs" component={IISGostZahtevOstaliResursComponent}></Route>
            <Route path = "/gostvididogadjaj" component={IISGostVidiDogadjajComponent}></Route>
            <Route path = "/gostorganizujdogadjaj" component={IISGostOrganizujDogadjajComponent}></Route>

              </Switch>
          </div>
                                
        </Router>
     
     
    </div>
    
  );
}

export default App;
