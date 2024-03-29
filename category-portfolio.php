<?php
get_header();
?>

<!-- Catch Line and Link -->
<h2 class="grid_12 caption clearfix">Our <span>portfolio</span>, home to our latest, and greatest work.</h2>

<div class="hr grid_12 clearfix">&nbsp;</div>

<!-- Section 3 -->
<?php if (have_posts()) : while (have_posts()) : the_post(); ?>
        <div class="catagory_1 clearfix">        
    <?php
        $project_name = get_post_meta($post->ID, "my_project_name", true);

        $portfolios = get_post_custom_values('my_portfolio_thumb_image');
    ?>
        <!-- Row 1 -->    
        <div class="grid_3 textright" >    
            <span class="meta"><?php the_title(); ?></span>
            <h4 class="title "><?php echo $project_name; ?></h4>
            <div class="hr clearfix dotted">&nbsp;</div>    
            <p><?php the_excerpt(); ?></p>
        </div>    
        <div class="grid_9">    
    
        <?php
        $count = 0;
        $portfolio_item_class = "";
        foreach ($portfolios as $key => $value) {
            if ($count % 3 == 0)
                $portfolio_item_class = "alpha";
            else if ($count % 3 == 2)
                $portfolio_item_class = "omega";
        ?>
    
            <a class="portfolio_item float <?php echo $portfolio_item_class; ?>" href="<?php the_permalink() ?>">
                <span><?php echo $project_name; ?></span>
                <img class="" src="<?php echo $value; ?>"  alt=""/>
            </a>    
    
    
        <?php
            $count++;
        }
        ?>
    </div>
</div>

<div class="pr clearfix grid_12">&nbsp;</div>
<?php endwhile;
    else: ?>
        
        <h2>Woops...</h2>        
        
        <p>Sorry, no posts we're found.</p>        
        
<?php endif; ?>
        
        <!-- Page Navigation -->        
        <p class="clearfix">        
    <?php wp_link_pages(array('next_or_number' => 'next', 'previouspagelink' => ' &laquo; ', 'nextpagelink' => ' &raquo;')); ?>
    </p>    
    
<?php get_footer(); ?>