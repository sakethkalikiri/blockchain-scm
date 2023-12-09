import React from "react"; 

import Link from '@material-ui/core/Link';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import GitHubIcon from '@material-ui/icons/GitHub';

import "../../css/Footer.css"; 
 
/**
 * Footer component. Present in every page when user is an authenticated one.
 * 
 * @author saket
 */
export default function Footer({isAuthenticated}) {
    if(!isAuthenticated){
        return null;
    } else {
        return(
            <div>
                <center>
                    <footer>
                        <Container maxWidth="sm" > 
                            <Typography variant="body1" style={{ fontSize: 13}}> 
                            <div className="AppFooter">
                                {/* social media */}
                                <Grid container justifyContent="center">
                                    <Grid item xs={2}>
                                        <Link className="FooterLink" href="https://github.com/sakethkalikiri" target="_blank" >{" "}<GitHubIcon /></Link>
                                    </Grid>
                                </Grid>
                                <br/>
                                Powered by <Link className="FooterLink" href="https://mui.com/" target="_blank" >material-ui</Link> and 
                                <Link className="FooterLink" href="https://reactjs.org/" target="_blank" 
                                > {" "}React</Link> &copy; {new Date().getFullYear()} 
                                </div>
                            </Typography> 
                        </Container>
                    </footer>
                </center>
            </div>
        );
    } 
};
