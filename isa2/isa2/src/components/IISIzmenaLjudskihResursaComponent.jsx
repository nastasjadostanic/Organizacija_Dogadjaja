import React, { Component } from 'react';
import axios from 'axios';

class IISIzmenaLjudskihResursaComponent extends Component {
    constructor(props){
        super(props)
        this.state={
            id: this.props.match.params.id,
            naziv: '',
            cena: '',
            vrsta: '',
            brojLjudi: '',
            oblastDelovanja: '',
            brojTelefona: ''
            
        }
       
        this.changeNazivHandler = this.changeNazivHandler.bind(this);
        this.changeCenaHandler = this.changeCenaHandler.bind(this);
        this.changeVrstaHandler = this.changeVrstaHandler.bind(this);
        this.changeBrojLjudiHandler = this.changeBrojLjudiHandler.bind(this);
        this.changeOblastDelovanjaHandler = this.changeOblastDelovanjaHandler.bind(this);
        this.changeBrojTelefonaHandler = this.changeBrojTelefonaHandler.bind(this);


        //this.logout= this.logout.bind(this); 
       
    }
    changeNazivHandler = (event) => {
        this.setState({ naziv: event.target.value });
    }
    changeCenaHandler = (event) => {
        this.setState({ cena: event.target.value });
    }
    changeVrstaHandler = (event) => {
        this.setState({ vrsta: event.target.value });
    }
    changeBrojLjudiHandler = (event) => {
        this.setState({ brojLjudi: event.target.value });
    }
    changeOblastDelovanjaHandler = (event) => {
        this.setState({ oblastDelovanja: event.target.value });
    }
    changeBrojTelefonaHandler = (event) => {
        this.setState({ brojTelefona: event.target.value });
    }

    logout() {
        localStorage.clear();
        this.props.history.push(`/login`);

    }
    
    update(){
        let activeLjudskiResurs =  JSON.parse(localStorage.getItem('activeLjudskiResurs'))
        activeLjudskiResurs.id =this.state.id;  
        activeLjudskiResurs.naziv =this.state.naziv;      
        activeLjudskiResurs.cena=this.state.cena;
        activeLjudskiResurs.vrsta  =this.state.vrsta;  
        activeLjudskiResurs.brojLjudi=this.state.brojLjudi;
        activeLjudskiResurs.oblastDelovanja=this.state.oblastDelovanja;
        activeLjudskiResurs.brojTelefona=this.state.brojTelefona;

        console.log('activeLjudskiResurs => ' + JSON.stringify(activeLjudskiResurs));
        axios.put("http://localhost:8080/api/v1/ljudskiResursi/organizator/" + activeLjudskiResurs.id, activeLjudskiResurs).then(response => {localStorage.setItem('activeLjudskiResurs', JSON.stringify(response.data));})
    
    }

    
    

    componentDidMount(){
        let activeLjudskiResurs =  JSON.parse(localStorage.getItem('activeLjudskiResurs'))
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'))

        if (activeUser.type != "organizator"){this.logout(); alert("Unauthorised access")}
        else{

        this.setState({
            id:activeLjudskiResurs.id,
            naziv:activeLjudskiResurs.naziv,
            cena:activeLjudskiResurs.cena,
            vrsta:activeLjudskiResurs.vrsta,
            brojLjudi:activeLjudskiResurs.brojLjudi,
            oblastDelovanja:activeLjudskiResurs.oblastDelovanja,
            brojTelefona:activeLjudskiResurs.brojTelefona

        });
    }
        
    }
    render() {
        return (
        
            <div>
                <div className="registrationdiv">
                    <br/><br/>
                                <label> Naziv: </label>
                                <input  name="naziv" className="form-control" value={this.state.naziv} onChange={this.changeNazivHandler} />
                                <label> Cena: </label>
                                <input name="cena" className="form-control" value={this.state.cena} onChange={this.changeCenaHandler} />
                                <label> Vrsta: </label>
                                <input name="vrsta" className="form-control" value={this.state.vrsta} onChange={this.changeVrstaHandler} />
                                <label> Broj ljudi: </label>
                                <input name="brojLjudi" className="form-control" value={this.state.brojLjudi} onChange={this.changeBrojLjudiHandler} />
                                <label> Oblast delovanja: </label>
                                <input name="oblastDelovanja" className="form-control" value={this.state.oblastDelovanja} onChange={this.changeOblastDelovanjaHandler} />
                                <label> Broj telefona: </label>
                                <input name="brojTelefona" className="form-control" value={this.state.brojTelefona} onChange={this.changeBrojTelefonaHandler} />
                            
                                            
                                <br/>
                                <div className="center"><button className="loginbtn" onClick={()=>this.update()}>Izmeni</button></div>
                               
                                

                </div>
            </div>

        )   ;
    }
}

export default IISIzmenaLjudskihResursaComponent;