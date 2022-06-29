import React, { Component } from 'react';

import axios from 'axios';
import validator from 'validator';

import UserService from '../services/UserService';
import ClientPointsService from '../services/ClientPointsService';

class LoginComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            email: '',
            password: '',
            emailErrorMessage: '',
            pointsId: '',

            allCottageFreeAppointments:[],
            allCottageScheduledAppointments:[],
            allCottageQuickAppointments:[],

            allShipFreeAppointments:[],
            allShipScheduledAppointments:[],
            allShipQuickAppointments:[],

            allAdventureFreeAppointments:[],
            allAdventureScheduledAppointments:[],
            allAdventureQuickAppointments:[],
        }
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.login = this.login.bind(this);
        this.register = this.register.bind(this);
        this.register = this.registeruser.bind(this);
        this.use = this.use.bind(this);

    }

    updateCottageHistory(today){
        for(let i = 0; i < this.state.allCottageFreeAppointments.length; i++) {    //prolaz kroz sve iz FREE baze i brise/secka ih na danasnji datum
                               
            if(this.state.allCottageFreeAppointments[i].startingDate < today && this.state.allCottageFreeAppointments[i].endingDate < today){
                axios.delete("http://localhost:8080/api/v1/cottagefreeappointments/"+this.state.allCottageFreeAppointments[i].id)
            }  
            
            else{   
                if(this.state.allCottageFreeAppointments[i].startingDate < today && this.state.allCottageFreeAppointments[i].endingDate > today){
                    this.state.allCottageFreeAppointments[i].startingDate=today;
                    axios.put("http://localhost:8080/api/v1/cottagefreeappointments/"+this.state.allCottageFreeAppointments[i].id, this.state.allCottageFreeAppointments[i])
                }

            }

        }

        for(let i = 0; i < this.state.allCottageQuickAppointments.length; i++) {    //prolaz kroz sve iz Quick baze i brise/secka ih na danasnji datum
                               
            if(this.state.allCottageQuickAppointments[i].startingDate < today && this.state.allCottageQuickAppointments[i].endingDate < today){
                axios.delete("http://localhost:8080/api/v1/cottagequickappointments/"+this.state.allCottageQuickAppointments[i].id)
            }  
            
            else{   
                if(this.state.allCottageQuickAppointments[i].startingDate < today && this.state.allCottageQuickAppointments[i].endingDate > today){
                    this.state.allCottageQuickAppointments[i].startingDate=today;
                    axios.put("http://localhost:8080/api/v1/cottagequickappointments/"+this.state.allCottageQuickAppointments[i].id, this.state.allCottageQuickAppointments[i])
                }

            }

        }

         
        for(let i = 0; i < this.state.allCottageScheduledAppointments.length; i++) {    //prolaz kroz sve iz Scheduled baze i prebacuje ih u History
                               
            if(this.state.allCottageScheduledAppointments[i].endingDate < today){
                axios.post("http://localhost:8080/api/v1/cottagehistoryappointments",this.state.allCottageScheduledAppointments[i]);
                axios.delete("http://localhost:8080/api/v1/cottageappointments/"+this.state.allCottageScheduledAppointments[i].id);
            }  
            
           
        }
    }


    updateShipHistory(today){   
        for(let i = 0; i < this.state.allShipFreeAppointments.length; i++) {    //prolaz kroz sve iz FREE baze i brise/secka ih na danasnji datum
                               
            if(this.state.allShipFreeAppointments[i].startingDate < today && this.state.allShipFreeAppointments[i].endingDate < today){
                axios.delete("http://localhost:8080/api/v1/shipfreeappointments/"+this.state.allShipFreeAppointments[i].id)
            }  
            
            else{   
                if(this.state.allShipFreeAppointments[i].startingDate < today && this.state.allShipFreeAppointments[i].endingDate > today){
                    this.state.allShipFreeAppointments[i].startingDate=today;
                    axios.put("http://localhost:8080/api/v1/shipfreeappointments/"+this.state.allShipFreeAppointments[i].id, this.state.allShipFreeAppointments[i])
                }

            }

        }

        for(let i = 0; i < this.state.allShipQuickAppointments.length; i++) {    //prolaz kroz sve iz Quick baze i brise/secka ih na danasnji datum
                               
            if(this.state.allShipQuickAppointments[i].startingDate < today && this.state.allShipQuickAppointments[i].endingDate < today){
                axios.delete("http://localhost:8080/api/v1/shipquickappointments/"+this.state.allShipQuickAppointments[i].id)
            }  
            
            else{   
                if(this.state.allShipQuickAppointments[i].startingDate < today && this.state.allShipQuickAppointments[i].endingDate > today){
                    this.state.allShipQuickAppointments[i].startingDate=today;
                    axios.put("http://localhost:8080/api/v1/shipquickappointments/"+this.state.allShipQuickAppointments[i].id, this.state.allShipQuickAppointments[i])
                }

            }

        }

         
        for(let i = 0; i < this.state.allShipScheduledAppointments.length; i++) {    //prolaz kroz sve iz Scheduled baze i prebacuje ih u History
                               
            if(this.state.allShipScheduledAppointments[i].endingDate < today){
                axios.post("http://localhost:8080/api/v1/shiphistoryappointments",this.state.allShipScheduledAppointments[i]);
                axios.delete("http://localhost:8080/api/v1/shipappointments/"+this.state.allShipScheduledAppointments[i].id);
            }  
            
           
        }

    }


    updateAdventureHistory(today){
        for(let i = 0; i < this.state.allAdventureFreeAppointments.length; i++) {    //prolaz kroz sve iz FREE baze i brise/secka ih na danasnji datum
                               
            if(this.state.allAdventureFreeAppointments[i].startingDate < today && this.state.allAdventureFreeAppointments[i].endingDate < today){
                axios.delete("http://localhost:8080/api/v1/adventurefreeappointments/"+this.state.allAdventureFreeAppointments[i].id)
            }  
            
            else{   
                if(this.state.allAdventureFreeAppointments[i].startingDate < today && this.state.allAdventureFreeAppointments[i].endingDate > today){
                    this.state.allAdventureFreeAppointments[i].startingDate=today;
                    axios.put("http://localhost:8080/api/v1/adventurefreeappointments/"+this.state.allAdventureFreeAppointments[i].id, this.state.allAdventureFreeAppointments[i])
                }

            }

        }

        for(let i = 0; i < this.state.allAdventureQuickAppointments.length; i++) {    //prolaz kroz sve iz Quick baze i brise/secka ih na danasnji datum
                               
            if(this.state.allAdventureQuickAppointments[i].startingDate < today && this.state.allAdventureQuickAppointments[i].endingDate < today){
                axios.delete("http://localhost:8080/api/v1/adventurequickappointments/"+this.state.allAdventureQuickAppointments[i].id)
            }  
            
            else{   
                if(this.state.allAdventureQuickAppointments[i].startingDate < today && this.state.allAdventureQuickAppointments[i].endingDate > today){
                    this.state.allAdventureQuickAppointments[i].startingDate=today;
                    axios.put("http://localhost:8080/api/v1/adventurequickappointments/"+this.state.allAdventureQuickAppointments[i].id, this.state.allAdventureQuickAppointments[i])
                }

            }

        }

         
        for(let i = 0; i < this.state.allAdventureScheduledAppointments.length; i++) {    //prolaz kroz sve iz Scheduled baze i prebacuje ih u History
                               
            if(this.state.allAdventureScheduledAppointments[i].endingDate < today){
                axios.post("http://localhost:8080/api/v1/adventurehistoryappointments",this.state.allAdventureScheduledAppointments[i]);
                axios.delete("http://localhost:8080/api/v1/adventureappointments/"+this.state.allAdventureScheduledAppointments[i].id);
            }  
            
           
        }

    }


    updateHistory(){
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();
        today = yyyy + '-' + mm + '-' + dd;

        this.updateCottageHistory(today);
        this.updateShipHistory(today);
        this.updateAdventureHistory(today);
    }

    login() {
        this.updateHistory();
        if (validator.isEmail(this.state.email)) {

         

          
            axios.post("http://localhost:8080/api/v1/login/" + this.state.email + "/" + this.state.password).then(response => {
                localStorage.setItem('activeUser', JSON.stringify(response.data));

                let activeUser = JSON.parse(localStorage.getItem('activeUser'));

                this.setState({ pointsId: activeUser.id })
                ClientPointsService.getClientPointsById(this.state.pointsId).then(response => {
                    localStorage.setItem('activeUserPoints', JSON.stringify(response.data));
                });

                switch (activeUser.type) {
                    case 'fishing_instructor':
                        this.props.history.push(`/fishinginstructorprofile`);
                        
                        break;
                    case 'ship_owner':
                        this.props.history.push(`/shipownerprofile`);
                        break;
    
                    case 'cottage_owner':
                        this.props.history.push('/cottageownerprofile');
                        break;
    
                    case 'Clinet':
    
    
                        this.props.history.push('/homepageclient');
                        break;
                    case 'admin':
                        //treba da resetuje lozinku
                        if (activeUser.password == "password") {
                            this.props.history.push(`/adminchangepassword`)
                            break;
                        }
                        else this.props.history.push(`/adminprofile`);
                        break;
    
                    case 'main_admin':
                        this.props.history.push(`/mainadminprofile`);
                        break;
    
                    default:
                        return 'NE ZNAM';
    
                }


            })





        } else {
            this.setState({ emailErrorMessage: 'Email is invalid' })

        }

    }





    registeruser() {
        this.props.history.push('/registeruser');
    }
    register() {
        this.props.history.push('/register');
    }
    use() {
        this.props.history.push('/use')
    }

    changeEmailHandler = (event) => {


        this.setState({ email: event.target.value });
    }
    changePasswordHandler = (event) => {
        this.setState({ password: event.target.value });
    }


    componentDidMount() {
        //localStorage.clear(); Ne moze da stoji jer sam backuje na login page u procesu logina
        axios.get("http://localhost:8080/api/v1/cottagefreeappointments").then((res)=>{this.setState({allCottageFreeAppointments: res.data});});
        axios.get("http://localhost:8080/api/v1/cottageappointments").then((res2)=>{this.setState({allCottageScheduledAppointments: res2.data});});
        axios.get("http://localhost:8080/api/v1/cottagequickappointments").then((res3)=>{this.setState({allCottageQuickAppointments: res3.data});});

        axios.get("http://localhost:8080/api/v1/shipfreeappointments").then((res4)=>{this.setState({allShipFreeAppointments: res4.data});});
        axios.get("http://localhost:8080/api/v1/shipappointments").then((res5)=>{this.setState({allShipScheduledAppointments: res5.data});});
        axios.get("http://localhost:8080/api/v1/shipquickappointments").then((res6)=>{this.setState({allShipQuickAppointments: res6.data});});

        axios.get("http://localhost:8080/api/v1/adventurefreeappointments").then((res7)=>{this.setState({allAdventureFreeAppointments: res7.data});});
        axios.get("http://localhost:8080/api/v1/adventureappointments").then((res8)=>{this.setState({allAdventureScheduledAppointments: res8.data});});
        axios.get("http://localhost:8080/api/v1/adventurequickappointments").then((res9)=>{this.setState({allAdventureQuickAppointments: res9.data});});
        

    }

    render() {
        return (
            <div>
                <div style={{ position: 'absolute', top: '150px', left: '33%', height: '300px', width: '500px' }} >

                    <div style={{ position: 'absolute', top: '0px', left: '0px' }} className="logindiv">
                        <h3 style={{ position: 'absolute', top: '20px', left: '40%' }} className="text-center"> LOGIN </h3>

                        <form>
                            <div className="form-group">

                                <label style={{ position: 'absolute', left: '10px', top: '100px' }}> Email: </label>
                                <input style={{ position: 'absolute', top: '125px' }} placeholder="Email" name="email" className="form-control" value={this.state.email} onChange={this.changeEmailHandler} />
                                <div style={{ position: 'absolute', top: '165px', color: 'red', left: '38%' }}>{this.state.emailErrorMessage}</div>

                                <label style={{ position: 'absolute', left: '10px', top: '200px' }}> Password: </label>
                                <input style={{ position: 'absolute', top: '225px' }} type='password' placeholder="Password" name="password" className="form-control" value={this.state.password} onChange={this.changePasswordHandler} />

                                <div style={{ position: 'absolute', top: '315px' }} className="center"><button className="loginbtn" onClick={()=>this.login()}>Login</button></div>
                            </div>


                        </form>

                    </div>

                </div>

               
            </div>
        );
    }
}

export default LoginComponent;