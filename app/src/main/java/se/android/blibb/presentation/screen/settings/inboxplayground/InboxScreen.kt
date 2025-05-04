package se.android.blibb.presentation.screen.settings.inboxplayground

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Light
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import se.android.blibb.R
import se.android.blibb.presentation.component.PhoneCallIcon
import se.android.blibb.ui.theme.Black
import se.android.blibb.ui.theme.BlibbTheme
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_16dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_2dp
import se.android.blibb.ui.theme.DIMENS_4dp
import se.android.blibb.ui.theme.DIMENS_68dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.DIMENS_90dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.wheat

enum class TabPage {
    Light, Dark
}

@Composable
fun InboxScreen() {
    val allTasks = stringArrayResource(R.array.tasks)
    val allTopics = stringArrayResource(R.array.topics).toList()

    var tabPage by remember { mutableStateOf(TabPage.Light) }

    var weatherLoading by remember { mutableStateOf(false) }

    val tasks = remember { mutableStateListOf(*allTasks) }

    var expandedTopic by remember { mutableStateOf<String?>(null) }

    var editMessageShown by remember { mutableStateOf(false) }

    suspend fun loadWeather() {
        if (!weatherLoading) {
            weatherLoading = true
            delay(3000L)
            weatherLoading = false
        }
    }
    suspend fun showEditMessage() {
        if (!editMessageShown) {
            editMessageShown = true
            delay(3000L)
            editMessageShown = false
        }
    }
    LaunchedEffect(Unit) {
        loadWeather()
    }

    val lazyListState = rememberLazyListState()
    val backgroundColor = if (tabPage == TabPage.Light) wheat else MDark
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            InboxTabBar(
                backgroundColor = backgroundColor,
                tabPage = tabPage,
                onTabSelected = { tabPage = it }
            )
        },
        containerColor = backgroundColor,
        floatingActionButton = {
            InboxFloatingActionButton(
                extended = lazyListState.isScrollingUp(),
                onClick = {
                    coroutineScope.launch {
                        showEditMessage()
                    }
                }
            )
        }
    ) { padding ->
        Box(modifier = Modifier.padding(
            top = padding.calculateTopPadding(),
            start = padding.calculateLeftPadding(LayoutDirection.Ltr),
            end = padding.calculateEndPadding(LayoutDirection.Ltr)
        )) {
            LazyColumn(
                contentPadding = WindowInsets(
                    16.dp,
                    32.dp,
                    16.dp,
                    padding.calculateBottomPadding() + 32.dp
                ).asPaddingValues(),
                state = lazyListState
            ) {
                item { Header(title = stringResource(R.string.section_one)) }
                item { Spacer(modifier = Modifier.height(DIMENS_16dp)) }
                item { WeatherRow() }
                item { Spacer(modifier = Modifier.height(32.dp)) }
                item { Header(title = stringResource(R.string.section_two)) }
                item { Spacer(modifier = Modifier.height(16.dp)) }
                items(allTopics) { topic ->
                    TopicRow(
                        topic = topic,
                        expanded = expandedTopic == topic,
                        onClick = {
                            expandedTopic = if (expandedTopic == topic) null else topic
                        }
                    )
                }
                item { Spacer(modifier = Modifier.height(32.dp)) }
                item { Header(title = stringResource(R.string.section_three)) }
                item { Spacer(modifier = Modifier.height(16.dp)) }
                if (tasks.isEmpty()) {
                    item {
                        TextButton(
                            onClick = { tasks.clear(); tasks.addAll(allTasks)
                            })
                        {
                            Text(stringResource(R.string.add_tasks))
                        }
                    }
                }
                items(tasks, key = { it }) { task ->
                    TaskRow(
                        task = task
                    )
                }
            }
            EditMessage(editMessageShown)
        }
    }
}

@Composable
private fun InboxFloatingActionButton(
    extended: Boolean,
    onClick: () -> Unit
) {
    FloatingActionButton(onClick = onClick) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = null
            )
            if (extended) {
                Text(
                    text = stringResource(R.string.edit),
                    modifier = Modifier
                        .padding(start = 8.dp, top = 3.dp)
                )
            }
        }
    }
}

@Composable
private fun EditMessage(shown: Boolean) {
    AnimatedVisibility(
        visible = shown
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.secondary,
            shadowElevation = 18.dp
        ) {
            Text(
                text = stringResource(R.string.edit_message),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
private fun LazyListState.isScrollingUp(): Boolean {
    var previousIndex by remember(this) { mutableIntStateOf(firstVisibleItemIndex) }
    var previousScrollOffset by remember(this) { mutableIntStateOf(firstVisibleItemScrollOffset) }
    return remember(this) {
        derivedStateOf {
            if (previousIndex != firstVisibleItemIndex) {
                previousIndex > firstVisibleItemIndex
            } else {
                previousScrollOffset >= firstVisibleItemScrollOffset
            }.also {
                previousIndex = firstVisibleItemIndex
                previousScrollOffset = firstVisibleItemScrollOffset
            }
        }
    }.value
}

@Composable
private fun Header(
    title: String
) {
    Text(
        text = title,
        modifier = Modifier.semantics { heading() },
        style = MaterialTheme.typography.headlineLarge
    )
}

@Composable
private fun TopicRow(
    topic: String, expanded: Boolean,
    onClick: () -> Unit)
{
    TopicRowSpacer(visible = expanded)
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shadowElevation = DIMENS_4dp,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(DIMENS_16dp)
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null)
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = topic,
                    style = MaterialTheme.typography.bodySmall)
            }
            if (expanded) {
                Spacer(modifier = Modifier.height(DIMENS_8dp))
                Text(
                    text = stringResource(R.string.expanded),
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
    TopicRowSpacer(visible = expanded)
}

@Composable
fun TopicRowSpacer(visible: Boolean) {
    AnimatedVisibility(visible = visible) {
        Spacer(modifier = Modifier.height(DIMENS_8dp))
    }
}

@Composable
private fun InboxTabBar(
    backgroundColor: Color,
    tabPage: TabPage,
    onTabSelected: (tabPage: TabPage) -> Unit
) {
    Column(
        modifier = Modifier)
    {
        Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))
        TabRow(
            selectedTabIndex = tabPage.ordinal,
            containerColor = backgroundColor,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            indicator = { tabPositions ->
                InboxTabIndicator(tabPositions, tabPage)
            }
        ){
            InboxTab(
                icon = Icons.Default.Light,
                title = stringResource(R.string.light),
                onClick = { onTabSelected(TabPage.Light) }
            )
            InboxTab(
                icon = Icons.Default.Lightbulb,
                title = stringResource(R.string.dark),
                onClick = { onTabSelected(TabPage.Dark) }
            )
        }
    }
}

@Composable
private fun InboxTabIndicator(
    tabPositions: List<TabPosition>,
    tabPage: TabPage
) {
    val indicatorLeft = tabPositions[tabPage.ordinal].left
    val indicatorRight = tabPositions[tabPage.ordinal].right
    val color = if (tabPage == TabPage.Light) Ros else wheat
    Box(
        Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.BottomStart)
            .offset(x = indicatorLeft)
            .width(indicatorRight - indicatorLeft)
            .padding(DIMENS_4dp)
            .fillMaxSize()
            .border(
                BorderStroke(DIMENS_2dp, color),
                RoundedCornerShape(DIMENS_8dp))
    )
}

@Composable
private fun InboxTab(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier)
{
    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(DIMENS_16dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically)
    {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MSecond
        )
        Spacer(modifier = Modifier.width(DIMENS_16dp))
        Text(text = title, color = MSecond)
    }
}

@Composable
private fun WeatherRow(
) {
    Surface(
        color = wheat,
        shape = RoundedCornerShape(DIMENS_8dp),
        modifier = Modifier
            .fillMaxWidth(),
        shadowElevation = DIMENS_16dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = DIMENS_90dp)
                .padding(DIMENS_8dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "TEXT here",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MDark,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Box(
                modifier = Modifier
                    .padding(start = DIMENS_20dp)
                    .drawBehind {
                        drawRoundRect(
                            color = Color.Gray,
                            style = Stroke(
                                width = 2f,
                                pathEffect = PathEffect.dashPathEffect(
                                    floatArrayOf(10f, 10f),
                                    0f
                                )
                            ),
                            cornerRadius = CornerRadius(8.dp.toPx())
                        )
                    },
                contentAlignment = Alignment.Center
            ) {
                Card(
                    border = BorderStroke(1.dp, color = Black.copy(0.46f)),
                    shape = CircleShape)
                {
                    Image(
                        modifier = Modifier
                            .clip(CircleShape)
                            .padding(DIMENS_10dp)
                            .height(DIMENS_68dp)
                            .width(DIMENS_68dp)
                            .clickable( onClick = {}),
                        painter = painterResource(id = R.drawable.cake),
                        contentScale = ContentScale.Crop,
                        contentDescription = "image"
                    )
                }
            }
            Card(
                modifier = Modifier
                    .padding(DIMENS_10dp),
                border = BorderStroke(1.dp, color = Black.copy(0.46f)),
                shape = RoundedCornerShape(DIMENS_10dp),
            ) {
                Image(
                    modifier = Modifier
                        .clickable( onClick = {})
                        .height(DIMENS_68dp)
                        .width(DIMENS_68dp),
                    painter = painterResource(id = R.drawable.bg_b),
                    contentScale = ContentScale.Crop,
                    contentDescription = "image"
                )
            }
        }
    }
}

@Composable
private fun TaskRow(task: String) {
    Surface(
        color = Ros,
        modifier = Modifier
            .fillMaxWidth(),
        shadowElevation = DIMENS_16dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            PhoneCallIcon("+123 0123456789")
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                modifier = Modifier
                    .padding(top = DIMENS_20dp),
                text = task,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview
@Composable
private fun PreviewHomeTabBar() {
    BlibbTheme {
        InboxTabBar(
            backgroundColor = Color.White,
            tabPage = TabPage.Light,
            onTabSelected = {}
        )
    }
}

@Preview
@Composable
private fun PreviewHome() {
    BlibbTheme {
        InboxScreen()
    }
}