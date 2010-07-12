<?php get_header(); ?>

<!-- Featured Image Slider -->
<div id="featured" class="clearfix grid_12">
    <ul> 
        <?php
        $the_query = new WP_Query('category_name=featured');
        while ($the_query->have_posts()) : $the_query->the_post();
        ?>
            <li>    
                <a href="<?php the_permalink() ?>">
                    <span><?php the_title_attribute(); ?></span>
                    <img src="<?php echo get_post_meta($post->ID, 'my_portfolio_image', true); ?>" alt=""/>
                </a>    
            </li>      
        <?php endwhile; ?>
        </ul>     
    </div>    
    <div class="hr grid_12 clearfix">&nbsp;</div>    
    
    <div id="quicknav" class="grid_12">    
        <a class="quicknavgrid_3 quicknav alpha" href="portfolio.html">    
            <h4 class="title ">Recent Work</h4>    
            <p>Cras vestibulum lorem et dui mollis sed posuere leo semper. </p>    
            <p style="text-align:center;"><img alt="" src="<?php bloginfo('template_url'); ?>/images/Art_Artdesigner.lv.png" /></p>
    
        </a>    
        <a class="quicknavgrid_3 quicknav" href="about.html">    
            <h4 class="title ">Learn about us</h4>    
            <p>Cras vestibulum lorem et dui mollis sed posuere leo semper. </p>    
            <p style="text-align:center;"><img alt="" src="<?php bloginfo('template_url'); ?>/images/info.png" /></p>
    
        </a>    
        <a class="quicknavgrid_3 quicknav" href="blog.html">    
            <h4 class="title ">Read our blog</h4>    
            <p>Cras vestibulum lorem et dui mollis sed posuere leo semper. </p>    
            <p style="text-align:center;"><img alt="" src="<?php bloginfo('template_url'); ?>/images/Blog_Artdesigner.lv.png" /></p>
    
        </a>    
        <a class="quicknavgrid_3 quicknav" href="#">    
            <h4 class="title ">Follow on Twitter</h4>    
            <p>Cras vestibulum lorem et dui mollis sed posuere leo semper. </p>    
            <p style="text-align:center;"><img alt="" src="<?php bloginfo('template_url'); ?>/images/hungry_bird.png" /></p>
        </a>    
    </div>    
    
    <div class="hr grid_12 clearfix quicknavhr">&nbsp;</div>    
    
    <div id="quicknav" class="grid_12">    
        <a class="quicknavgrid_3 quicknav alpha" href="<?php echo get_option('home'); ?>/category/portfolio/">
            <h4 class="title ">Recent Work</h4>    
            <p>Our portfolio, home to our latest, and greatest work. </p>    
            <p style="text-align:center;"><img alt="" src="<?php bloginfo('template_url'); ?>/images/Art_Artdesigner.lv.png" /></p>
    
        </a>    
        <a class="quicknavgrid_3 quicknav" href="<?php echo get_option('home'); ?>/about">
            <h4 class="title ">Learn about us</h4>    
            <p>Learn about us and what we do best.</p>    
            <p style="text-align:center;"><img alt="" src="<?php bloginfo('template_url'); ?>/images/info.png" /></p>
    
        </a>    
        <a class="quicknavgrid_3 quicknav" href="<?php echo get_option('home'); ?>/category/blog/">
            <h4 class="title ">Read our blog</h4>    
            <p>Our blog, keeping you up-to-date on our latest news.</p>    
            <p style="text-align:center;"><img alt="" src="<?php bloginfo('template_url'); ?>/images/Blog_Artdesigner.lv.png" /></p>
    
        </a>    
        <a class="quicknavgrid_3 quicknav" href="<?php echo get_option('home'); ?>/contact-us">
            <h4 class="title ">Follow on Twitter</h4>    
            <p>Enjoyed looking at our work? Don't hesitate to contact us! </p>    
            <p style="text-align:center;"><img alt="" src="<?php bloginfo('template_url'); ?>/images/hungry_bird.png" /></p>
        </a>    
    </div>    
    <div class="hr grid_12 clearfix">&nbsp;</div>    
    
<?php get_footer(); ?>