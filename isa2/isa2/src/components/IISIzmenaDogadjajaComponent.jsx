import React, { Component } from 'react';
import axios from 'axios';

class IISIzmenaDogadjajaComponent extends Component {
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
            salaID: ''
            
        }
       
        this.changeUkupnaCenaHandler = this.changeUkupnaCenaHandler.bind(this);
        this.changeDatumNaplateHandler = this.changeDatumNaplateHandler.bind(this);
        this.changeDatumOdrzavanjaHandler = this.changeDatumOdrzavanjaHandler.bind(this);
        this.changeVremeOdrzavanjaHandler = this.changeVremeOdrzavanjaHandler.bind(this);
        this.changeTrajanjeHandler = this.changeTrajanjeHandler.bind(this);
        this.changeTipHandler = this.changeTipHandler.bind(this);
        this.changeSalaIdHandler = this.changeSalaIdHandler.bind(this);

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
    changeSalaIdHandler = (event) => {
        this.setState({ salaId: event.target.value });
    }

    logout() {
        localStorage.clear();
        this.props.history.push(`/login`);

    }
    
    update(){

        let activeDogadjaj =  JSON.parse(localStorage.getItem('activeDogadjaj'))

        activeDogadjaj.id=this.state.id;
        activeDogadjaj.ukupnaCena=this.state.ukupnaCena;
        activeDogadjaj.datumNaplate=this.state.datumNaplate;
        activeDogadjaj.datumOdrzavanja=this.state.datumOdrzavanja;
        activeDogadjaj.vremeOdrzavanja=this.state.vremeOdrzavanja;
        activeDogadjaj.trajanje=this.state.trajanje;
        activeDogadjaj.tip=this.state.tip;
        activeDogadjaj.salaID=this.state.salaID;
        activeDogadjaj.gostId=this.state.gostId;
        

        console.log('activeDogadjaj => ' + JSON.stringify(activeDogadjaj));

        
        axios.put("http://localhost:8080/api/v1/dogadjaji/organizator/" + activeDogadjaj.id, activeDogadjaj).then(response => {localStorage.setItem('activeDogadjaj', JSON.stringify(response.data));})
    
    }

    componentDidMount(){
        let activeDogadjaj =  JSON.parse(localStorage.getItem('activeDogadjaj'))
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'))

        if (activeUser.type != "organizator"){this.logout(); alert("Unauthorised access")}
        else{

        this.setState({
            id:activeDogadjaj.id,
            ukupnaCena:activeDogadjaj.ukupnaCena,
            datumNaplate:activeDogadjaj.datumNaplate,
            datumOdrzavanja:activeDogadjaj.datumOdrzavanja,
            vremeOdrzavanja:activeDogadjaj.vremeOdrzavanja,
            trajanje:activeDogadjaj.trajanje,
            tip:activeDogadjaj.tip,
            salaID:activeDogadjaj.salaID

        });
    }
        
    }
    render() {
        return (
        
            <div>
                <div className="registrationdiv">
                    <br/><br/>
                                <label> Ukupna ccena: </label>
                                <input name="ukupnaCena" className="form-control" value={this.state.ukupnaCena} onChange={this.changeUkupnaCenaHandler}/>
                                <label> Datum Naplate: </label>
                                <input type = "date" name="datumNaplate" className="form-control" value={this.state.datumNaplate} onChange={this.changeDatumNaplateHandler}/>
                                <label> Datum odrzavanja: </label>
                                <input type = "date" name="datumOdrzavanja" className="form-control" value={this.state.datumOdrzavanja} onChange={this.changeDatumOdrzavanjaHandler}/>
                                <label> Vreme odrzavanja: </label>
                                <input name="vremeOdrzavanja" className="form-control" value={this.state.vremeOdrzavanja} onChange={this.changeVremeOdrzavanjaHandler}/>
                                <label> Trajanje: </label>
                                <input name="trajanje" className="form-control" value={this.state.trajanje} onChange={this.changeTrajanjeHandler}/>
                                <label> Tip: </label>
                                <input name="tip" className="form-control" value={this.state.tip} onChange={this.changeTipHandler}/>
                                <label> Sala id: </label>
                                <input name="dalaId" className="form-control" value={this.state.salaID} onChange={this.changeSalaIdHandler}/>

                                
                                <br/>
                                <div className="center"><button className="loginbtn" onClick={()=>this.update()}>Izmeni</button></div>
                               
                                

                </div>
            </div>

        )   ;
    }
}

export default IISIzmenaDogadjajaComponent;