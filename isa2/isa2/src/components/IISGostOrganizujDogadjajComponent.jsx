import React, { Component } from 'react';
import axios from 'axios';

class IISGostVidiDogadjajComponent extends Component {
    constructor(props){
        super(props)
        this.state={
            id: this.props.match.params.id,
            ukupnaCena: '',
            datumNaplate: '',
            datumOdrzavanja: '',
            vremeOdrzavanja: '',
            trajanje: '',
            tip: '',
            salaID: '',
            ljudskiResursId:'',
            ostaliResursId: ''
            
        }
       
        this.changeUkupnaCenaHandler = this.changeUkupnaCenaHandler.bind(this);
        this.changeDatumNaplateHandler = this.changeDatumNaplateHandler.bind(this);
        this.changeDatumOdrzavanjaHandler = this.changeDatumOdrzavanjaHandler.bind(this);
        this.changeVremeOdrzavanjaHandler = this.changeVremeOdrzavanjaHandler.bind(this);
        this.changeTrajanjeHandler = this.changeTrajanjeHandler.bind(this);
        this.changeTipHandler = this.changeTipHandler.bind(this);
        this.changeVrstaHandler = this.changeVrstaHandler.bind(this);
        this.changeSalaIdHandler = this.changeSalaIdHandler.bind(this);
        this.changeModifikacijaSaleHandler = this.changeModifikacijaSaleHandler.bind(this);
        this.changeLjudskiHandler = this.changeLjudskiHandler.bind(this);
        this.changeOstaliHandler = this.changeOstaliHandler.bind(this);

        
        this.logout= this.logout.bind(this); 
       
    }
    changeUkupnaCenaHandler = (event) => {
        this.setState({ ukupnaCena: event.target.value });
    }
    changeDatumNaplateHandler = (event) => {
        this.setState({ datumNaplate: event.target.value });
    }
    changeDatumOdrzavanjaHandler = (event) => {
        this.setState({ datumOdrzavanja: event.target.value });
    }
    changeVremeOdrzavanjaHandler = (event) => {
        this.setState({ vremeOdrzavanja: event.target.value });
    }
    changeTrajanjeHandler = (event) => {
        this.setState({ trajanje: event.target.value });
    }
    changeTipHandler = (event) => {
        this.setState({ tip: event.target.value });
    }
    changeVrstaHandler = (event) => {
        this.setState({ vrsta: event.target.value });
    }
    changeSalaIdHandler = (event) => {
        this.setState({ salaId: event.target.value });
    }
    changeModifikacijaSaleHandler = (event) => {
        this.setState({ modifikacijaSale: event.target.value });
    }
    changeLjudskiHandler = (event) => {
        this.setState({ ljudskiResursId: event.target.value });
    }
    changeOstaliHandler = (event) => {
        this.setState({ ostaliResursId: event.target.value });
    }

    logout() {
        localStorage.clear();
        this.props.history.push(`/login`);

    }
    
    zahtev(){
        let sala = JSON.parse(localStorage.getItem('activeSala'));
        let user = JSON.parse(localStorage.getItem('activeUser'));
        let zahtev={
            
            datumOdrzavanja: this.state.datumOdrzavanja,
            vremeOdrzavanja: this.state.vremeOdrzavanja,
            trajanje: this.state.trajanje,
            vrsta: "Privatan",
            salaID: sala.id,
            ljudskiResursId:this.state.ljudskiResursId,
            ostaliResursId: this.state.ostaliResursId,
            organizator: "ne",
            brojMesta: this.state.brojMesta,
            gostID: user.id
        }
        console.log(zahtev);

        //kreiranje zahteva
        axios.post("http://localhost:8080/api/v1/zahteviPrivatanDogadjaj/gost", zahtev)
    }

    componentDidMount(){
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        
        if (activeUser.type == "gost")
        {
        } 
        else{this.logout(); alert("Unauthorised access")} 

        
    }
        
    
    render() {
        return (
        
            <div>
                <div className="registrationdiv">
                    <br/><br/>
                                <label> Datum odrzavanja: </label>
                                <input type = "date" name="datumOdrzavanja" className="form-control" value={this.state.datumOdrzavanja}onChange={this.changeDatumOdrzavanjaHandler} />
                                <label> Vreme odrzavanja: </label>
                                <input name="vremeOdrzavanja" className="form-control" value={this.state.vremeOdrzavanja} onChange={this.changeVremeOdrzavanjaHandler}/>
                                <label> Trajanje: </label>
                                <input name="trajanje" className="form-control" value={this.state.trajanje} onChange={this.changeTrajanjeHandler} />
                                <label> Tip: </label>
                                <input name="tip" className="form-control" value={this.state.tip} onChange={this.changeTipHandler}/>
                                <label> Broj mesta: </label>
                                <input name="brojMesta" className="form-control" value={this.state.brojMesta} onChange={this.changeBrojMestaHandler}/>
                                
                                <label> Modifikacija sale: </label>
                                <input name="modifikacija" className="form-control" value={this.state.modifikacijaSale}onChange={this.changeModifikacijaSaleHandler} />
                                <label> Ljudski resurs id: </label>
                                <input name="ljudski" className="form-control" value={this.state.ljudskiResursId}onChange={this.changeLjudskiHandler} />
                                <label> Ostali resurs id: </label>
                                <input name="ostali" className="form-control" value={this.state.ostaliResursId}onChange={this.changeOstaliHandler} />

                                
                                <br/>
                                <div className="center"><button className="loginbtn" onClick={()=>this.zahtev()}>Zahtevaj</button></div>
                        
                </div>
            </div>

        );
    }
}
export default IISGostVidiDogadjajComponent;