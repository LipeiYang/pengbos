<?php get_header(); ?>

		<div class="grid_9 omega right-column">
			 <!-- START HOME PAGE -->
            <div class="home">
                <!--<img src="images/text-home.jpg" alt="contenuto-home" />-->
                <h1>
                      <?php
                        $the_query = new WP_Query('pagename=home');
                        while ($the_query->have_posts()) : $the_query->the_post();
                        ?>
                            <?php the_content();?>
                        <?php endwhile; ?>
                </h1>
                <!--<img src="images/arrow-home.png" alt="arrow" class="arrow" />-->
            </div>
            <div class="home-bottom-bg"></div>
            <!-- END HOME PAGE -->
			
			<!-- START ABOUT PAGE -->
            <a id="about-page"></a>
            
            <div class="about">
                    
                <div class="grid_5 alpha">
                
                    <div class="container-about">
                        <h2>About</h2>
                        
                      <?php
                        $the_query = new WP_Query('pagename=about');
                        while ($the_query->have_posts()) : $the_query->the_post();
                        ?>
                            <?php the_content();?>
                        <?php endwhile; ?>
                    </div>
                </div>
                
                <!-- START AVATAR -->
                <div class="grid_4 omega avatar-image">
                    <img src="<?php bloginfo('template_url'); ?>/images/avatar.jpg" alt="avatar" class="avatar" />
                </div>
                <!-- END AVATAR -->
                
                <div class="clear"></div>
            </div>
            <div class="about-bottom-bg"></div>
            <!-- END ABOUT PAGE -->
			
			 <!-- START PORTFOLIO PAGE -->
            <a id="portfolio-page"></a>
            
            <div class="portfolio">
            	<div class="grid_4 alpha">
	                <div class="container-portfolio">
	                    <h2>Portfolio</h2>
                    </div>
                </div>
                
                <!-- START PORTFOLIO QUOTE -->
                <div class="grid_4 omega">
                	<div class="portfolio-quote">
                		<h4>I hope you like my work and my work speaks for me.</h4>
                	</div>
                </div>
                <!-- END PORTFOLIO QUOTE -->
                
                <div class="clear"></div>
                
                <div class="container-portfolio">
                    
                    <!-- START THUMB IMAGE -->
                    <div class="photo">
                        <a href="#project01">
                            <img src="<?php bloginfo('template_url'); ?>/scripts/timthumb.php?src=images/portfolio/003.big.jpg&amp;h=85&amp;w=85&amp;zc=1" alt="WordPress Theme" />
                        </a>
                    </div>
                    
                    <div class="photo">
                        <a href="#project02">
                            <img src="<?php bloginfo('template_url'); ?>/scripts/timthumb.php?src=images/portfolio/001.big.jpg&amp;h=85&amp;w=85&amp;zc=1" alt="Asilo nido" />
                        </a>
                    </div>
                    
                    <div class="photo">
                        <a href="#project03">
                            <img src="<?php bloginfo('template_url'); ?>/scripts/timthumb.php?src=images/portfolio/002.big.jpg&amp;h=85&amp;w=85&amp;zc=1" alt="One Page Folio" />
                        </a>
                    </div>
                    
                    <div class="photo">
                        <a href="#project04">
                            <img src="<?php bloginfo('template_url'); ?>/scripts/timthumb.php?src=images/portfolio/004.big.jpg&amp;h=85&amp;w=85&amp;zc=1" alt="Eclectic: Premium WordPress Theme" />
                        </a>
                    </div>
                    
                    <div class="photo">
                        <a href="#project05">
                            <img src="<?php bloginfo('template_url'); ?>/scripts/timthumb.php?src=images/portfolio/005.big.jpg&amp;h=85&amp;w=85&amp;zc=1" alt="Gold: Premium WordPress Theme" />
                        </a>
                    </div>
                    
                    <div class="photo">
                        <a href="#project06">
                            <img src="<?php bloginfo('template_url'); ?>/scripts/timthumb.php?src=images/portfolio/006.big.jpg&amp;h=85&amp;w=85&amp;zc=1" alt="" />
                        </a>
                    </div>
                    
                    <div class="photo">
                        <a href="#project07">
                            <img src="<?php bloginfo('template_url'); ?>/scripts/timthumb.php?src=images/portfolio/004.big.jpg&amp;h=85&amp;w=85&amp;zc=1" alt="" />
                        </a>
                    </div>
                    
                    <div class="photo">
                        <a href="#project08">
                            <img src="<?php bloginfo('template_url'); ?>/scripts/timthumb.php?src=images/portfolio/003.big.jpg&amp;h=85&amp;w=85&amp;zc=1" alt="" />
                        </a>
                    </div>
                    
                    <div class="photo">
                        <a href="#project09">
                            <img src="<?php bloginfo('template_url'); ?>/scripts/timthumb.php?src=images/portfolio/001.big.jpg&amp;h=85&amp;w=85&amp;zc=1" alt="" />
                        </a>
                    </div>
                    
                    <div class="photo">
                        <a href="#project10">
                            <img src="<?php bloginfo('template_url'); ?>/scripts/timthumb.php?src=images/portfolio/002.big.jpg&amp;h=85&amp;w=85&amp;zc=1" alt="Asilo nido" />
                        </a>
                    </div>
                    
                    <div class="clear"></div>
                    <!-- END SMALL IMAGE -->
                    
                    <!-- START BIG IMAGE -->
                    <div id="project01">
                        <img href="<?php bloginfo('template_url'); ?>/images/portfolio/003.big.jpg"/>
                            
                    </div>
                    
                    <div id="project02">
                        <img href="<?php bloginfo('template_url'); ?>/images/portfolio/001.big.jpg"/>
                          
                    </div>
                    
                    <div id="project03">
                        <img href="<?php bloginfo('template_url'); ?>/images/portfolio/002.big.jpg"/>
                    </div>
                    
                    <div id="project04">
                        <img href="<?php bloginfo('template_url'); ?>/images/portfolio/004.big.jpg"/>
                         
                    </div>
                    
                    <div id="project05">
                        <img href="<?php bloginfo('template_url'); ?>/images/portfolio/005.big.jpg"/>
                       
                    </div>
                    
                    <div id="project06">
                        <img href="<?php bloginfo('template_url'); ?>/images/portfolio/006.big.jpg"/>
                         
                    </div>
                    
                    <div id="project07">
                        <img href="<?php bloginfo('template_url'); ?>/images/portfolio/004.big.jpg"/>
                         
                    </div>
                    
                    <div id="project08">
                        <img href="<?php bloginfo('template_url'); ?>/images/portfolio/003.big.jpg"/>
                    </div>
                    
                    <div id="project09">
                        <img href="<?php bloginfo('template_url'); ?>/images/portfolio/001.big.jpg"/>
                        
                    </div>
                    
                    <div id="project10">
                        <img href="<?php bloginfo('template_url'); ?>/images/portfolio/002.big.jpg"/>
                    </div>
                    <!-- END BIG IMAGE -->

                </div>
            </div>
            <div class="portfolio-bottom-bg"></div>
            <!-- END PORTFOLIO PAGE -->
			
			 <!-- START CONTACT PAGE -->
            <a id="contact-page"></a>
            
            <div class="contact">
           <?php
                    $the_query = new WP_Query('pagename=contact');
                    while ($the_query->have_posts()) : $the_query->the_post();
                    ?>
                <div class="grid_5 alpha">
                    
                    <div class="container-contact">
                        <h2>Contact</h2>
                        <div id="log"></div>
                        
                            <form id="contacts" method="post" action="">
                            <fieldset>
                                <input tabindex="1" type="text" id="visitor" name="visitor" value="Name" onfocus="if (this.value=='Name') this.value='';" onblur="if (this.value=='') this.value='Name';" class="text name" />
                                <br />
                                
                                <input tabindex="3" type="text" id="visitormail" name="visitormail" value="E-mail" onfocus="if (this.value=='E-mail') this.value='';" onblur="if (this.value=='') this.value='E-mail';" class="text mail" />
                                <br />
                                
                                <textarea tabindex="4" id="notes" name="notes" cols="30" rows="3" onfocus="if (this.value=='Message') this.value='';" onblur="if (this.value=='') this.value='Message';" class="text message">Message</textarea>
                                <br />

                                <input type="hidden" name="your_email" value="<?php echo get_option('admin_email'); ?>">
                                <input type="hidden" name="your_web_site_name" value="<?php echo get_bloginfo('name'); ?>">
                        
                            	<input class="button" id="send_message" name="Send" value="Send e-mail" type="submit" />
                            	
                        	</fieldset>
                        </form>
                      
                    </div>
                </div>
                
                <div class="grid_4 omega contact-info">
                    <p class="title">Estimates, questions, information?</p>
                    
                    <p>
                        <?php the_content();?>
                    </p>
                    
                    <img src="<?php bloginfo('template_url'); ?>/images/logo.small.gif" alt="logo" class="contact-logo" />
                    
                    <h3>YourInspirationFolio</h3>
                    
                    <address>Arlington Road, 988</address>
                    
                    <p class="right">
                        <span>Tel.</span> 074 5678 678<br/>
                        <span>Fax.</span> 074 5678 678
                    </p>
                </div>
               <?php endwhile; ?>
                <div class="clear"></div>
            </div>
            
            <div class="contact-bottom-bg"></div>
            <!-- END CONTACT PAGE -->
    </div>       

<?php get_footer(); ?>